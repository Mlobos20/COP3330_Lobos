public class Square extends Shape2D {
    protected double size;

    Square(double sidelen){
        super("square");
        this.size = sidelen;
    }

    @Override
    public String getName(){
        return name;
    }

    @Override
    public double getArea(){
        return Math.pow(this.size,2);
    }

}
