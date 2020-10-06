public class Square extends Shape2D {
    protected String name;
    protected double size;

    Square(double sidelen){
        this.name = "square";
        this.size = sidelen;
    }


    public String getName(){
        return name;
    }

    public double getArea(){
        return Math.pow(this.size,2);
    }

}
