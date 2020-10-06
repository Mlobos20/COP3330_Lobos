public class Square extends Shape2D {
    protected double size;

    Square(double sidelen){
        super("square");
        this.size = sidelen;
    }


    public String getName(){
        return name;
    }

    public double getArea(){
        return Math.pow(this.size,2);
    }

}
