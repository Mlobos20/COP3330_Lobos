import java.util.Scanner;

public class App {

    private static Scanner scnr = new Scanner(System.in);

    public static void main(String[] args) {

        int userchoice = 0;
        while (userchoice != 3) {
            printAppSelectionMenu();
            userchoice = getAppMenuChoice();

            switch (userchoice) {
                case 1:
                    System.out.println("User entered 1");
                    System.out.println("Now entering Task List interface");
                    TaskApp tskApp = new TaskApp();
                    tskApp.start();
                    break;
                case 2:
                    System.out.println("User entered 2");
                    System.out.println("Now entering Contact List interface");
                    ContactApp cntApp = new ContactApp();
                    cntApp.start();
                    break;
            }
        }
        System.out.println("User entered 3");
        System.out.println("Now terminating program...");
    }

    // Issue is either here, or in contact app. Issue is that whenever we choose to access the contact menu
    // it automatically kicks us back out here and displays that the user entered 3, when they did not; will work
    // on when not dead
    private static int getAppMenuChoice(){
        int input = scnr.nextInt();
        scnr.nextLine();
        return input;
    }

    private static void printAppSelectionMenu(){
        System.out.println("Select your Application");
        System.out.println("------------------------");
        System.out.println("1) task list");
        System.out.println("2) contact list");
        System.out.println("3) quit");
    }

}
