import java.util.ArrayList;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        ArrayList<BodyMassIndex> bmiData = new ArrayList<BodyMassIndex>();

        while (moreInput()) {
            double height = getUserHeight();
            double weight = getUserWeight();

            BodyMassIndex bmi = new BodyMassIndex(height, weight);
            bmiData.add(bmi);

            displayBmiInfo(bmi);
        }

        displayBmiStatistics(bmiData);
    }

    private static boolean moreInput() {
        System.out.println("Do you have more data to input? Y/N");
        Scanner input = new Scanner(System.in);
        String ans;
        boolean choice = false;
        ans = input.nextLine();
        if (ans.equalsIgnoreCase("Y")){
            choice = true;
        }
        if (ans.equalsIgnoreCase("N")) {
            choice = false;
        }

        return choice;
    }

    private static void displayBmiStatistics(ArrayList<BodyMassIndex> bmiData) {
        double summedBMIs = 0;
        double curBMIval;
        double avgBMI;
        BodyMassIndex curBMI = new BodyMassIndex(0,0);

        for (int i = 0; i < bmiData.size(); i++) {
            curBMI = bmiData.get(i);
            curBMIval = curBMI.BMI;
            summedBMIs += curBMIval;
        }
        avgBMI = summedBMIs / bmiData.size();

        System.out.printf("The average BMI from the entered data is : %.2f%n", avgBMI );

    }

    private static void displayBmiInfo(BodyMassIndex bmi) {
        double BMI = bmi.BMI;
        String category = bmi.category;
        System.out.printf("BMI : %.1f --> %s%n", BMI, category);
    }

    private static double getUserHeight(){
        Scanner input = new Scanner(System.in);
        boolean goodVal = false;
        double height = 0;
        while (goodVal == false) {
            System.out.println("Please enter a Height (in inches)");
            height = input.nextDouble();
            input.nextLine();
            if (height < 0){
                System.out.println("Please enter a positive value");
                goodVal = false;
            }
            else {
                goodVal = true;
            }
        }
        return height;
    }

    private static double getUserWeight(){
        Scanner input = new Scanner(System.in);
        boolean goodVal = false;
        double weight = 0;
        while (goodVal == false) {
            System.out.println("Please enter a Weight (in pounds)");
            weight = input.nextDouble();
            input.nextLine();
            if (weight < 0){
                System.out.println("Please enter a positive value");
                goodVal = false;
            } else {
                goodVal = true;
            }
        }
        return weight;
    }

}
