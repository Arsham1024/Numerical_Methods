import java.util.ArrayList;

public class Newton_Raphson {

   //value of Xi is given
   double Xi;
   // C is basically Xi+1 or next value of Xi
   double C;

   //Desired Error to reach or better
   double desired_Error = 0.001;
   double epsilon;
   ArrayList<Double> epsilonValues_Newton = new ArrayList<>();

   //Max iteration
   static final int MAX = 100;

   public void solve_F1(double x){
      Xi = x;
      //Calculating the first round by hand becusse error would not make sense yet.
      C = Xi - function1(Xi)/Diff_Function1(Xi);
      Xi = C;
      C = Xi - function1(Xi)/Diff_Function1(Xi);


      for (int i = 0; i < MAX; i++) {
         epsilon = Math.abs(getEpsilon());
         epsilonValues_Newton.add(epsilon);
         if(epsilon < desired_Error){
            System.out.println("desired error reached at iteration "  + (i+1));
            System.out.println("Error at this stage: "+ getEpsilon());
            System.out.printf("C = %.7f\n", C);
            break;
         }
         else{
            Xi = C;
            C = Xi - function1(Xi)/Diff_Function1(Xi);
         }
      }
   }

   public void solve_F2(double x){
      Xi = x;
      //Calculating the first round by hand becusse error would not make sense yet.
      C = Xi - function2(Xi)/Diff_Function2(Xi);
      Xi = C;
      C = Xi - function2(Xi)/Diff_Function2(Xi);


      for (int i = 0; i < MAX; i++) {
         epsilon = Math.abs(getEpsilon());
         epsilonValues_Newton.add(epsilon);
         if(epsilon < desired_Error){
            System.out.println("desired error reached at iteration "  + (i+1));
            System.out.println("Error at this stage: "+ getEpsilon());
            System.out.printf("C = %.7f\n", C);
            break;
         }
         else{
            Xi = C;
            C = Xi - function2(Xi)/Diff_Function2(Xi);
         }
      }
   }

   private double getEpsilon() {
      return Math.abs((C-Xi)/C);
   }

   private static double Diff_Function1(double x){
      return (6*Math.pow(x,2) - 23.4*x + 17.7);
   }
   private static double Diff_Function2(double x){
      return (1 - Math.cosh(50/x) + (50/x)*Math.sinh(50/x));
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
