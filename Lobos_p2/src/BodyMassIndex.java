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
        double temp = 0;
        temp = Math.round(this.unroundedBMI*10)/10.0;

        return temp;
    }

}
