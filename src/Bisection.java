import java.util.ArrayList;

/**
 * bracketing method. since for each function we know the interval at which the root lies I will store them.
 */
public class Bisection {

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

   //Desired Error to reach or better
   double desired_Error = 0.001;

   //Max iteration
   static final int MAX = 100;

   //To store all the epsilon values
   ArrayList <Double> epsilonValues_Bisection = new ArrayList<>();


   /**
    * This method will find the roots of the given equation and return an array of y coordinates
    * @return an array of doubles containing all the coordinates of the functions
    */
   public double solve_F1Bisection(double a, double b){

      //assign the A and B. we know the root is between 0 - 4, so we choose A and B to bracket the root.
      A = a;
      B = b;
      //A loop that runs a maximum of 100 times
      //choosing z as a variable so that for inside loops I can have the i and j available.
      for (int i = 0; i < MAX; i++) {

         //calculate the value of C
         C_n0 = calc_C_Value();

         //calculate functional values with A and B and C
         Func_a = function1(A);
//         System.out.println("F(a) = " + Func_a);
         Func_b = function1(B);
//         System.out.println("F(b) = " + Func_b);
         Func_c = function1(C_n0);
//         System.out.println("F(c) = " + Func_c);

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
         //collecting all the errors.
         epsilonValues_Bisection.add(epsilon);

         //keep track of the C value by assigning Current C to last C before starting a new iteration.
         C_n1 = C_n0;

         if(epsilon <= desired_Error) {
            System.out.println("desired error reached at iteration "  + (i+1));
            System.out.println("Error at this stage: "+ Math.abs(epsilon));
            System.out.printf("C = %.7f\n", C_n0);
            break;
         }
      }

//      System.out.println(solution.length + "    " + solution[1].length);
      return C_n0;
   }

   /**
    * This method will solve the second given equation and find the root values
    * @param a the lower bound of the bracket
    * @param b the upper bound of the bracket
    * @return the solution between the brackets
    */
   public double solve_F2Bisection(double a, double b){

      //assign the A and B. we know the root is between 0 - 4, so we choose A and B to bracket the root.
      A = a;
      B = b;
      //A loop that runs a maximum of 100 times
      //choosing z as a variable so that for inside loops I can have the i and j available.
      for (int i = 0; i < MAX; i++) {

         //calculate the value of C
         C_n0 = calc_C_Value();

         //calculate functional values with A and B and C
         Func_a = function2(A);
//         System.out.println("F(a) = " + Func_a);
         Func_b = function2(B);
//         System.out.println("F(b) = " + Func_b);
         Func_c = function2(C_n0);
//         System.out.println("F(c) = " + Func_c);

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
         epsilonValues_Bisection.add(epsilon);

         //keep track of the C value by assigning Current C to last C before starting a new iteration.
         C_n1 = C_n0;

         if(epsilon <= desired_Error) {
            System.out.println("desired error reached at iteration "  + i);
            System.out.println("Error at this stage: "+ Math.abs(epsilon));
            System.out.printf("C = %.7f\n", C_n0);
            break;
         }
      }

//      System.out.println(solution.length + "  " + solution[1].length);
      return C_n0;
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
    * calculate the C value
    * @return C value
    */
   private double calc_C_Value(){
      return (A+B)/2;
   }

   /**
    * Calculate the approximate relative error
    * @return the appx rel error
    */
   private double calc_Approx_Relative_Err(){
      return (C_n0-C_n1)/C_n0;
   }
}
