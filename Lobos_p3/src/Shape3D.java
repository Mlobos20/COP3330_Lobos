public class Shape3D extends Shape {
    protected String name;

    Shape3D(){
        this.name = "Shape3D";
    }

    public String getName(){
        return this.name;
    }

    public double getArea(){
        return 0;
    }

    public double getVolume(){
        return 0;
    }

}
