import java.util.ArrayList;

public class Secant_Modified {

   // delta is given
   float delta = 0.01F;

   //Xi is the current X and C is the next value of Xi
   double Xi;
   double C;

   //Functional value of Xi and C
   double F_Xi;
   double F_C;

   //0.001 or better
   double desiredError = 0.001;
   double epsilon;
   ArrayList <Double> epsilonValues_SecantM = new ArrayList<>();

   //max number of iterations
   static final int MAX = 100;

   public double solve_F1(double a){
      Xi = a;
      epsilon = 1;

      for (int i = 0; i < MAX ; i++) {
         C = calc_C();
         F_Xi = function1(Xi);
         F_C = function1(C);
         epsilon = Math.abs(calc_Epsilon());
         epsilonValues_SecantM.add(epsilon);

         if(F_C == 0 || epsilon < desiredError){
            System.out.println("iteration " + i);
            System.out.println("C is " + C);
            System.out.println("Xi is " + Xi);
            break;
         }else {
            Xi = C;
         }
      }
      return C;
   }

   public double solve_F2(double a){
      Xi = a;
      epsilon = 1;

      for (int i = 0; i < MAX ; i++) {
         C = calc_C();
         F_Xi = function2(Xi);
         F_C = function2(C);
         epsilon = Math.abs(calc_Epsilon());
         epsilonValues_SecantM.add(epsilon);

         if(F_C == 0 || epsilon < desiredError){
            System.out.println("iteration " + i);
            System.out.println("C is " + C);
            System.out.println("Xi is " + Xi);
            break;
         }else {
            Xi = C;
         }
      }
      return C;
   }

   private double calc_Epsilon(){
      return ((F_C-F_Xi)/F_C);
   }

   private double calc_C (){
      // for simplicity I pulled out this product.
      double dXi = delta*Xi;
      return (Xi - function1(Xi)) * (dXi/(function1(Xi+dXi)-function1(Xi)));
   }

   private double calc_Xi_1(){
      return (Xi - function1(Xi) * ((C-Xi)/(function1(C)-function1(Xi))));
   }

   /**
    * This method will solve the first function for the given X value
    * @param x the given x value to solve equation for.
    * @return the solution for the given x
    */
   private static double function1 (double x){
      return (2 * Math.pow(x,3)) - (11.7 * Math.pow(x,2)) + (17.7 * x) - 5;
   }
   // similar to the last function this will solve the second function for the given x
   private static double function2 (double x){
      return (x+10) - (x * Math.cosh(50/x));
   }
}
