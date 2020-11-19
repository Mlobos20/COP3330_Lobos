import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TaskApp {


        private TaskList tskList;
        // creates instance where everything takes place
        public TaskApp(){
            tskList = new TaskList();
        }

        private void userInteraction(){
            int UserInput = 0;
            // loop that waits for good input, if non-valid input is received, it prompts the user again
            while(UserInput != 3) {
                PrintMainMenu();
                UserInput = getMenu1Input();
                switch (UserInput) {
                    // User wants to make new list, so we prompt for name and make the list
                    case 1:
                        System.out.println("User entered 1");
                        System.out.println("Please enter the name of the List (DO NOT INCLUDE THE EXTENSION) you would like to create (This will be used as the filename)");
                        String newListName = getFileName();
                        tskList.setTitles(newListName);
                        listOperationMenuInteraction(tskList);
                        break;
                    case 2:
                        // User wants to load a list, so we prompt for the list and try to deserialize the list from directory
                        boolean success = false;
                        while (!success) {
                            try {
                                tskList = new TaskList();
                                System.out.println("User entered 2");
                                System.out.println("Please enter the filename (DO NOT INCLUDE THE EXTENSION) of the list you would like to open from the current directory (Type 'Cancel' to cancel)");
                                String preExistingListName = getFileName();
                                if (preExistingListName.equalsIgnoreCase("Cancel")){
                                    System.out.println("User issued cancel, returning to main menu...");
                                    break;
                                }
                                tskList.setTitles(preExistingListName);
                                tskList.deSerializeFile();
                                success = true;
                                listOperationMenuInteraction(tskList);
                            } catch (FileNotFoundException e) {
                                System.out.println("Error locating the file with given file name");
                                System.out.println("Please enter the file name again...");
                                System.out.println();
                            }
                        }
                        break;
                }
            }
            // If we made it here that means the user wanted to exit the program
            System.out.println("User entered 3: now exiting the program");
        }


        private void listOperationMenuInteraction(TaskList tskList){
            int userInput = 0;
            int taskChoice;
            // another loop waiting for valid input
            while(userInput != 8) {
                boolean validInput = false;
                PrintOperationMenu();
                userInput = getMenu2Input();
                switch (userInput) {
                    case 1:
                        // view the list
                        if (tskList.isListEmpty()) {
                            System.out.println("List is empty :(");
                        } else {
                            tskList.ListToString();
                        }
                        break;
                    case 2:
                        // add an item
                        while (!validInput) {
                            try {
                                System.out.println("Please enter the name of the task (Must be more than 1 character)");
                                String taskName = getUserInput();
                                System.out.println("Please enter a description of the task (Optional)");
                                String taskDesc = getUserInput();
                                System.out.println("Please enter a due date in the following format: YYYY-MM-DD");
                                String taskDueDate = getUserInput();
                                TaskItem tsk = new TaskItem(taskName, taskDesc, taskDueDate);
                                tskList.addItem(tsk);
                                validInput = true;
                            } catch (IllegalArgumentException e) {
                                System.out.println("Incorrect input, please try again");
                                System.out.println();
                            }
                        }
                        break;
                    case 3:
                        // edit an item
                        while (!validInput) {
                            try {
                                System.out.println("Please enter the number of the task you would like to edit");
                                taskChoice = getTaskNumber();
                                if (tskList.verifyIndex(taskChoice)) {
                                    System.out.println("Please enter the edited Title");
                                    String newTitle = getUserInput();
                                    tskList.editItemTitle(taskChoice, newTitle);
                                    System.out.println("Please enter the edited Description");
                                    String newDesc = getUserInput();
                                    tskList.editItemDesc(taskChoice, newDesc);
                                    System.out.println("Please enter the edited Due Date");
                                    String newDueDate = getUserInput();
                                    tskList.editItemDueDate(taskChoice, newDueDate);
                                    validInput = true;
                                }
                            } catch (IndexOutOfBoundsException e) {
                                System.out.println("Incorrect input, please try again");
                                System.out.println("Please enter a task number between 0 and " + (tskList.getListSize()-1));
                                System.out.println();
                            } catch (IllegalArgumentException e) {
                                System.out.println("Incorrect input, please try again");
                                System.out.println("Make sure your title is 1 or more character, and your date is in the format : YYYY-MM-DD %n");
                                System.out.println();
                            } catch (InputMismatchException e) {
                                System.out.println("Incorrect input, please try again");
                                System.out.println("Please enter a task number between 0 and " + (tskList.getListSize()-1));
                            }
                        }
                        break;
                    case 4:
                        // remove an item
                        while(!validInput) {
                            try {
                                System.out.println("Please enter the task number you would like to remove");
                                taskChoice = getTaskNumber();
                                if (tskList.verifyIndex(taskChoice)) {
                                    tskList.removeItem(taskChoice);
                                    validInput = true;
                                }
                            } catch (IndexOutOfBoundsException e) {
                                System.out.println("Incorrect input, please try again");
                                System.out.println("Please enter a task number between 0 and " + (tskList.getListSize()-1));
                                System.out.println();
                            } catch (InputMismatchException e) {
                                System.out.println("Incorrect input, please try again");
                                System.out.println("Please enter a task number between 0 and " + (tskList.getListSize()-1));
                                System.out.println();
                            }
                        }
                        break;
                    case 5:
                        // mark an item as completed
                        while(!validInput) {
                            try {
                                System.out.println("Please enter the task number you would like to mark as complete");
                                taskChoice = getTaskNumber();
                                if (tskList.verifyIndex(taskChoice)) {
                                    tskList.markComplete(taskChoice);
                                    validInput = true;
                                }
                            } catch (IndexOutOfBoundsException e) {
                                System.out.println("Incorrect input, please try again");
                                System.out.println("Please enter a task number between 0 and " + (tskList.getListSize()-1));
                                System.out.println();
                            } catch (InputMismatchException e) {
                                System.out.println("Incorrect input, please try again");
                                System.out.println("Please enter a task number between 0 and " + (tskList.getListSize()-1));
                                System.out.println();
                            }
                        }
                        break;
                    case 6:
                        // unmark an item as incomplete
                        while(!validInput) {
                            try {
                                System.out.println("Please enter a task number between 0 and " + (tskList.getListSize() - 1));
                                taskChoice = getTaskNumber();
                                if(tskList.verifyIndex(taskChoice)) {
                                    tskList.markIncomplete(taskChoice);
                                    validInput = true;
                                }
                            } catch (IndexOutOfBoundsException e){
                                System.out.println("Incorrect input, please try again");
                                System.out.println("Please enter a task number between 0 and " + (tskList.getListSize()-1));
                                System.out.println();
                            } catch (InputMismatchException e) {
                                System.out.println("Incorrect input, please try again");
                                System.out.println("Please enter a task number between 0 and " + (tskList.getListSize()-1));
                                System.out.println();
                            }
                        }
                        break;
                    case 7:
                        // save the current list
                        tskList.serializeToFile();
                        break;
                }
            }
            // If we're here, user decided to return to main menu
            System.out.println("returning to the main menu");
        }

        // various input functions depending on context
        private String getFileName(){
            Scanner scnr = new Scanner(System.in);
            String input = null;
            boolean validInput = false;
            while (!validInput){
                try{
                    input = scnr.nextLine();
                    if(input.length() < 1){
                        throw new IllegalArgumentException();
                    }
                    validInput = true;
                } catch (IllegalArgumentException e){
                    System.out.println("The filename cannot be empty, it must be 1 or more characters...");
                }
            }
            return input;
        }

        private int getMenu1Input(){
            int choice = 0;
            Scanner scnr = new Scanner(System.in);
            boolean validInput  = false;
            while (!validInput) {
                try {
                    choice = scnr.nextInt();
                    if (choice < 1 || choice > 3) {
                        throw new IllegalArgumentException();
                    }
                    validInput = true;
                } catch (IllegalArgumentException e){
                    System.out.println("Please enter an integer between 1 and 3");
                } catch (InputMismatchException e){
                    System.out.println("Please enter an integer between 1 and 3");
                    scnr.nextLine();
                }
            }
            return choice;
        }

        private int getMenu2Input(){
            Scanner scnr = new Scanner(System.in);
            int choice = 0;
            boolean validInput  = false;
            while (!validInput) {
                try {
                    choice = scnr.nextInt();
                    if (choice < 1 || choice > 8) {
                        throw new IllegalArgumentException();
                    }
                    validInput = true;
                } catch (IllegalArgumentException e){
                    System.out.println("Please enter an integer between 1 and 8");
                } catch (InputMismatchException e){
                    System.out.println("Please enter an integer between 1 and 8");
                    scnr.nextLine();
                }
            }
            return choice;
        }

        private String getUserInput(){
            Scanner scnr = new Scanner(System.in);
            return scnr.nextLine();
        }

        private int getTaskNumber(){
            Scanner scnr = new Scanner(System.in);
            return scnr.nextInt();
        }

        // dedicated function to print main menu options
        private static void PrintMainMenu(){
            System.out.println("Menu");
            System.out.println("------------------------");
            System.out.println("1) create a new list");
            System.out.println("2) load an existing list");
            System.out.println("3) quit");
        }

        // dedicated function to print list options
        private static void PrintOperationMenu(){
            System.out.println("List Operation Menu");
            System.out.println("--------------------");
            System.out.println("1) view the list");
            System.out.println("2) add an item");
            System.out.println("3) edit an item");
            System.out.println("4) remove an item");
            System.out.println("5) mark an item as completed");
            System.out.println("6) unmark an item as completed");
            System.out.println("7) save the current list");
            System.out.println("8) quit to the main menu");
        }

        public static void main(String[] args) {

            TaskApp m = new TaskApp();

            m.userInteraction();
        }

}
