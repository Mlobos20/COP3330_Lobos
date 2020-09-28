import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

public class BodyMassIndex {

public double height;
public double weight;
public double BMI;
public double unroundedBMI;
public String category;


    public BodyMassIndex(double height, double weight){
        //I think this is the constructor?
        Assign(height, weight);

        this.unroundedBMI = Calculate();

        this.category = categorize();

        this.BMI = Round();
    }

    // I basically made the constructor into a method, probably not the best idea though
    public void Assign(double height, double weight){
        this.height = height;
        this.weight = weight;
    }


    public double Calculate(){
        double result = 0;
        result = (703*this.weight)/(Math.pow(height,2));
        return result;
    }


    public String categorize(){
        String selectedCategory = null;
        if(this.unroundedBMI <= 18.5){
            selectedCategory = "Underweight";
        }
        if(this.unroundedBMI >= 18.5 && this.unroundedBMI <= 24.9){
            selectedCategory = "Normal Weight";
        }
        if(this.unroundedBMI >= 25 && this.unroundedBMI <= 29.9){
            selectedCategory = "Overweight";
        }
        if(this.unroundedBMI >= 30){
            selectedCategory = "Obese";
        }

        return selectedCategory;
    }

    public double Round(){
        // Realized I couldn't use math.round since it returned a long, and I wanted to adhere to the assignment guide lines
        // So instead I used a big decimal to do the rounding, and then returned the double value of it.
        BigDecimal roundingPlaceholder = new BigDecimal(Double.toString(this.unroundedBMI));
        roundingPlaceholder = roundingPlaceholder.setScale(1, RoundingMode.HALF_UP);
        double temp = 0;
        temp = roundingPlaceholder.doubleValue();

        return temp;
    }

}
