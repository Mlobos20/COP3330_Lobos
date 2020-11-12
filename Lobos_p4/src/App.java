import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        int UserInput = 0;
        while(UserInput != 3) {
            PrintMainMenu();
            UserInput = getMenu1Input();
            switch (UserInput) {
                case 1:
                    System.out.println("User entered 1");
                    System.out.println("Please enter the name of the List you would like to create (This will be used as the filename)");
                    String newListName= getFileName();
                    TaskList tskList = new TaskList(newListName);
                    listOperationMenuInteraction(tskList);
                    break;
                case 2:
                    System.out.println("User entered 2");
                    System.out.println("Please enter the filename of the list you would like to open from the current directory");
                    String preExistingListName = getFileName();
                    break;
            }
        }
        System.out.println("User entered 3: now exiting the program");
    }

    public static void listOperationMenuInteraction(TaskList tskList){
        // PrintOperationMenu();
        int userInput = 0;
        int taskChoice = 0;
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
                            System.out.println("");
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
                            System.out.println("Please enter a task number within the available range ");
                            System.out.println("");
                        } catch (IllegalArgumentException e) {
                            System.out.println("Incorrect input, please try again");
                            System.out.println("Make sure your title is 1 or more character, and your date is in the format : YYYY-MM-DD %n");
                            System.out.println("");
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
                            System.out.println("Please enter a task number within the available range");
                            System.out.println("");
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
                            System.out.println("Please enter a task number within the available range");
                            System.out.println("");
                        }
                    }
                    break;
                case 6:
                    // unmark an item as incomplete
                    System.out.println("Please enter the task number you would like to mark as complete");
                    taskChoice = getTaskNumber();
                    tskList.markIncomplete(taskChoice);
                    break;
                case 7:
                    // save the current list
                    break;
            }
        }
        System.out.println("returning to the main menu");
    }

    public static String getFileName(){
        Scanner scnr = new Scanner(System.in);
        String fileName;
        fileName = scnr.nextLine();
        return fileName;
    }

    public static int getMenu1Input(){
        Scanner scnr = new Scanner(System.in);
        int choice = 0;
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
            }
        }
        return choice;
    }

    public static int getMenu2Input(){
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
            }
        }
        return choice;
    }

    public static String getUserInput(){
        Scanner scnr = new Scanner(System.in);
        return scnr.nextLine();
    }

    public static int getTaskNumber(){
        Scanner scnr = new Scanner(System.in);
        return scnr.nextInt();
    }

    public static void PrintMainMenu(){
        System.out.println("Menu");
        System.out.println("------------------------");
        System.out.println("1) create a new list");
        System.out.println("2) load an existing list");
        System.out.println("3) quit");
    }

    public static void PrintOperationMenu(){
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

    //This class will be the driver class of the application

    //Here is where the user interacts with the various menus
    // and makes their entries, such as titles and task list items

    // REQUIREMENTS

    // - A USER SHALL BE ABLE TO CREATE A NEW TASK LIST
    // - A USER SHALL BE ABLE TO LOAD AN EXISTING TASK LIST

    // - A USER SHALL BE ABLE TO VIEW THE CURRENT TASK LIST
    // - A USER SHALL BE ABLE TO SAVE THE CURRENT TASK LIST
    // - A USER SHALL BE ABLE TO ADD AN ITEM TO THE CURRENT TASK LIST
    // - A USER SHALL BE ABLE TO EDIT AN ITEM IN THE CURRENT TASK LIST
    // - A USER SHALL BE ABLE TO REMOVE AN ITEM FROM THE CURRENT TASK LIST
    // - A USER SHALL BE ABLE TO MARK AN ITEM IN THE CURRENT TASK LIST AS COMPLETED
    // - A USER SHALL BE ABLE TO UNMARK AN ITEM IN THE CURRENT TASK LIST AS COMPLETED

}
