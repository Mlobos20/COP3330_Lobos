public class Sphere extends Shape3D {
   protected double radius;


   Sphere(double radius){
      super("sphere");
      this.radius = radius;
   }

   @Override
   public String getName(){
      return name;
   }

   @Override
   public double getArea(){
      return (4*Math.PI*(Math.pow(radius,2)));
   }

   @Override
   public double getVolume(){
      return ((Math.pow(radius,3)*Math.PI*((double)4/(double)3)));
   }
}
