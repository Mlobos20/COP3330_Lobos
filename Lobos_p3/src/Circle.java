public class Circle extends Shape2D {
    protected String name;
    protected double radius;

    Circle(double radius){
        this.name = "circle";
        this.radius = radius;
    }

    public String getName(){
        return this.name;
    }

    public double getArea(){
        return (Math.PI*(Math.pow(this.radius, 2)));
    }
}
