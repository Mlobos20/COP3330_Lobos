import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ContactApp {

    private Scanner scnr = new Scanner(System.in);

    private ContactList cntList;

//    public ContactApp (){
//        cntList = new ContactList();
//    }

    private void userInteraction(){
        int UserInput = 0;
        // loop that waits for good input, if non-valid input is received, it prompts the user again
        while(UserInput != 3) {
            PrintMainMenu();
            UserInput = getMenu1Input();
            switch (UserInput) {
                // User wants to make new list, so we prompt for name and make the list
                case 1:
                    cntList = new ContactList();
                    System.out.println("User entered 1");
                    System.out.println("Please enter the name of the List (DO NOT INCLUDE THE EXTENSION) you would like to create (This will be used as the filename)");
                    String newListName = getUserInput();
                    cntList.setFilename(newListName);
                    listOperationMenuInteraction(cntList);
                    break;
                case 2:
                    // User wants to load a list, so we prompt for the list and try to deserialize the list from directory
                    boolean success = false;
                    while (!success) {
                        try {
                            cntList = new ContactList();
                            System.out.println("User entered 2");
                            System.out.println("Please enter the filename (DO NOT INCLUDE THE EXTENSION) of the list you would like to open from the current directory (Type 'Cancel' to cancel)");
                            String preExistingListName = getUserInput();
                            if (preExistingListName.equalsIgnoreCase("Cancel")){
                                System.out.println("User issued cancel, returning to main menu...");
                                break;
                            }
                            cntList.setFilename(preExistingListName);
                            cntList.deSerializeFile();
                            success = true;
                            listOperationMenuInteraction(cntList);
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

    private void listOperationMenuInteraction(ContactList cntList) {
        int userInput = 0;
        int taskChoice;
        while (userInput != 6){
            boolean validInput = false;
            PrintOperationMenu();
            userInput = getMenu2Input();
            switch (userInput){
                case 1:
                    // view the list
                    if (cntList.isListEmpty()) {
                        System.out.println("List is empty :(");
                    } else {
                        cntList.ListToString();
                    }
                    break;
                case 2:
                    // add an item
                    while (!validInput) {
                        try {
                            System.out.println("Please provide a value for AT LEAST one of the following fields");
                            System.out.println("Please enter the contacts First Name");
                            String fName = getUserInput();
                            System.out.println("Please enter the contacts Last Name");
                            String lName = getUserInput();
                            System.out.println("Please enter the contacts Phone Number");
                            String pNum = getUserInput();
                            System.out.println("Please enter the contacts Email Address");
                            String eAdd = getUserInput();
                            ContactItem cntct = new ContactItem(fName,lName,pNum,eAdd);
                            if(cntct.returnEmptyStatus() == true){
                                throw new IllegalArgumentException();
                            }
                            cntList.addContact(cntct);
                            validInput = true;
                        } catch (IllegalArgumentException e) {
                            System.out.println("Incorrect input, please try again");
                            System.out.println();
                        }
                    }
                    break;
                case 3:
                    // edit an item
                    while (!validInput){
                        try{
                            cntList.ListToString();
                            System.out.println("Please enter the contact number you would like to edit");
                            taskChoice = getTaskNumber();
                            if (cntList.verifyIndex(taskChoice)){
                                System.out.println("Please provide a value for AT LEAST one of the following fields");
                                scnr.nextLine();
                                System.out.println("Please enter the contacts First Name");
                                String fName = getUserInput();
                                System.out.println("Please enter the contacts Last Name");
                                String lName = getUserInput();
                                System.out.println("Please enter the contacts Phone Number");
                                String pNum = getUserInput();
                                System.out.println("Please enter the contacts Email Address");
                                String eAdd = getUserInput();
                                cntList.editContact(taskChoice,fName,lName,pNum,eAdd);
                                cntList.isValidContact(taskChoice);
                                validInput = true;
                            }
                        } catch (IndexOutOfBoundsException e){
                            System.out.println("Incorrect input, please try again");
                            System.out.println("Please enter a task number between 0 and " + (cntList.getListSize()-1));
                            System.out.println();
                        } catch (IllegalArgumentException e){
                            System.out.println("Incorrect input, please try again");
                            System.out.println("Please enter a value in AT LEAST 1 of the fields");
                            System.out.println();
                        } catch (InputMismatchException e){
                            System.out.println("Incorrect input, please try again");
                            System.out.println("Please enter a task number between 0 and " + (cntList.getListSize()-1));
                            System.out.println();
                        }
                    }
                    break;
                case 4:
                    // remove an item
                    while(!validInput){
                        try{
                            cntList.ListToString();
                            System.out.println("Please enter the contact number you would like to remove");
                            taskChoice = getTaskNumber();
                            if(cntList.verifyIndex(taskChoice)){
                                cntList.removeContact(taskChoice);
                                validInput = true;
                            }
                        } catch (IndexOutOfBoundsException e){
                            System.out.println("Incorrect input, please try again");
                            System.out.println("Please enter a task number between 0 and " + (cntList.getListSize()-1));
                            System.out.println();
                        } catch (InputMismatchException e){
                            System.out.println("Incorrect input, please try again");
                            System.out.println("Please enter a task number between 0 and " + (cntList.getListSize()-1));
                            System.out.println();
                        }
                    }
                    break;
                case 5:
                    // save the list
                    cntList.serializeToFile();
                    break;
            }

        }
        // If we're here, it means the user picked the exit option
        System.out.println("returning to main menu");
    }

    private int getTaskNumber(){
        return scnr.nextInt();
    }

    private String getUserInput() {
        return scnr.nextLine();
    }

    private int getMenu1Input() {
        int choice = 0;
        boolean validInput  = false;
        while (!validInput) {
            try {
                choice = scnr.nextInt();
                if (choice < 1 || choice > 3) {
                    throw new IllegalArgumentException();
                }
                scnr.nextLine();
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

    private int getMenu2Input() {
        int choice = 0;
        boolean validInput  = false;
        while (!validInput) {
            try {
                choice = scnr.nextInt();
                if (choice < 1 || choice > 6) {
                    throw new IllegalArgumentException();
                }
                scnr.nextLine();
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



    private static void PrintMainMenu(){
        System.out.println("Menu");
        System.out.println("------------------------");
        System.out.println("1) create a new list");
        System.out.println("2) load an existing list");
        System.out.println("3) quit");
    }

    private static void PrintOperationMenu(){
        System.out.println("List Operation Menu");
        System.out.println("--------------------");
        System.out.println("1) view the list");
        System.out.println("2) add an item");
        System.out.println("3) edit an item");
        System.out.println("4) remove an item");
        System.out.println("5) save the current list");
        System.out.println("6) quit to the main menu");
    }

    public void start(){

        userInteraction();
    }
}
