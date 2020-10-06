public class Sphere extends Shape3D {
   protected String name;
   protected double radius;


   Sphere(double radius){
      this.name = "sphere";
      this.radius = radius;
   }

   public String getName(){
      return name;
   }

   public double getArea(){
      return (4*Math.PI*(Math.pow(radius,2)));
   }

   public double getVolume(){
      return ((Math.pow(radius,3)*Math.PI*((double)4/(double)3)));
   }
}
