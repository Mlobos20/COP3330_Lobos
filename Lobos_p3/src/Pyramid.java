public class Pyramid extends Shape3D {
    protected double length;
    protected double width;
    protected double height;


    Pyramid(double length, double width, double height){
        super("pyramid");
        this.length = length;
        this.width = width;
        this.height = height;
    }

    public String getName(){
        return this.name;
    }

    public double getArea(){
        double ans = 0;
        ans = (length * width) + (length * (Math.sqrt((Math.pow(width/2,2) + (Math.pow(height,2)))))) + (width * (Math.sqrt((Math.pow(length/2,2)) + Math.pow(height,2))));

        return ans;
    }

    public double getVolume(){
        return (this.length *this.width *this.height)/3;
    }
}
