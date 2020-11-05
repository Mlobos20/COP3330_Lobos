import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        int UserInput;
        PrintMainMenu();
        UserInput = getUserInput();
        if(UserInput == 1){
            System.out.println("User chose: 1");
        }
        if(UserInput == 2){
            System.out.println("User chose: 2");
        }
        if(UserInput == 3){
            System.out.println("User chose: 3, program will now exit");
            System.exit(0);
        }
        PrintOperationMenu();
    }

    public static int getUserInput(){
        Scanner scnr = new Scanner(System.in);
        int choice;
        choice = scnr.nextInt();
        return choice;
    }

    public static void PrintMainMenu(){
        System.out.println("Menu");
        System.out.println("------------------------");
        System.out.println("");
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
