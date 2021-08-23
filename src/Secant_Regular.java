import java.util.ArrayList;

public class Secant_Regular {

   //we are given A and B, then we calculate C and replace with A or B;
   //C_n0 = the current C value
   //C_n1 = the last iteration's C value
   double C_n0;
   double C_n1;
   double A;
   double B;

   //Functional values at each of the points above:
   double Func_a;
   double Func_b;
   double Func_c;

   //Approximate Relative Error;
   double epsilon;
   ArrayList <Double> epsilonValues_Secant = new ArrayList<>();

   //Desired Error to reach or better
   double desired_Error = 0.001;


   //Max iteration
   static final int MAX = 100;

   public double solve_F1(double a , double b){
      //Get the appropriate values in place
      A = a;
      B = b;

      for (int i = 0; i <MAX ; i++) {
         C_n0 = calc_C_Value();

         //Get functional values
         Func_a = function1(A);
         Func_b = function1(B);
         Func_c = function1(C_n0);

         //if f(c) = 0  we have the root
         if(Func_c == 0){
            break;

            //This conditon means that one of these values must be negative and regardless of which it is
            //This also indicates that C has the same sign as B and so we should reassign B = C
         }else if (Func_c * Func_a < 0){
//            System.out.println("sign of C Matches B");
            B = C_n0;
            //This condition means that C and A have the same sign therefore we assign A = C
         }else{
//            System.out.println("sign of C matches A");
            A = C_n0;
         }

         epsilon = Math.abs(calc_Approx_Relative_Err());
         epsilonValues_Secant.add(epsilon);

         //keep track of the C value by assigning Current C to last C before starting a new iteration.
         C_n1 = C_n0;

         if(epsilon <= desired_Error) {
            System.out.println("desired error reached at iteration "  + (i+1));
            System.out.println("Error at this stage: "+ Math.abs(epsilon));
            System.out.printf("C = %.7f\n", C_n0);
            break;
         }
      }

      return C_n0;
   }
   public double solve_F2(double a, double b){
      //Get the appropriate values in place
      A = a;
      B = b;

      for (int i = 0; i <MAX ; i++) {
         C_n0 = calc_C_Value2();

         //Get functional values
         Func_a = function2(A);
         Func_b = function2(B);
         Func_c = function2(C_n0);

         //if f(c) = 0  we have the root
         if(Func_c == 0){
            break;

            //This conditon means that one of these values must be negative and regardless of which it is
            //This also indicates that C has the same sign as B and so we should reassign B = C
         }else if (Func_c * Func_a < 0){
//            System.out.println("sign of C Matches B");
            B = C_n0;
            //This condition means that C and A have the same sign therefore we assign A = C
         }else{
//            System.out.println("sign of C matches A");
            A = C_n0;
         }

         epsilon = Math.abs(calc_Approx_Relative_Err());
         epsilonValues_Secant.add(epsilon);

         //keep track of the C value by assigning Current C to last C before starting a new iteration.
         C_n1 = C_n0;

         if(epsilon <= desired_Error) {
            System.out.println("desired error reached at iteration "  + (i+1));
            System.out.println("Error at this stage: "+ Math.abs(epsilon));
            System.out.printf("C = %.7f\n", C_n0);
            break;
         }
      }
      return C_n0;
   }
   public double calc_C_Value(){
      return (A - function1(A) * ((B-A)/(function1(B)-function1(A))));
   }
   public double calc_C_Value2(){
      return (A - function2(A) * ((B-A)/(function2(B)-function2(A))));
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
   /**
    * Calculate the approximate relative error
    * @return the appx rel error
    */
   private double calc_Approx_Relative_Err(){
      return (C_n0-C_n1)/C_n0;
   }
}
