public abstract class Shape {
    protected String name;

    Shape(String input){
        this.name = input;
    }

    public abstract String getName();

    public abstract double getArea();

}
