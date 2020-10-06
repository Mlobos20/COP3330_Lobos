public class Triangle extends Shape2D {
    protected double base;
    protected double height;

    Triangle(double base, double height){
        super("triangle");
        this.base = base;
        this.height = height;
    }

    public String getName(){
        return name;
    }

    public double getArea(){
        return (this.base*this.height)/2;
    }

}
