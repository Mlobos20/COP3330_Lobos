public class Circle extends Shape2D {
    protected double radius;

    Circle(double radius){
        super("circle");
        this.radius = radius;
    }

    @Override
    public String getName(){
        return this.name;
    }

    @Override
    public double getArea(){
        return (Math.PI*(Math.pow(this.radius, 2)));
    }
}
