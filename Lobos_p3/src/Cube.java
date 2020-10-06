public class Cube extends Shape3D {
    protected String name;
    protected double sidelen;

    Cube(double sidelen){
        this.name = "cube";
        this.sidelen = sidelen;
    }

    public String getName(){
        return name;
    }

    public double getArea(){
        return (6*(Math.pow(sidelen,2)));
    }

    public double getVolume(){
        return Math.pow(sidelen, 3);
    }

}
