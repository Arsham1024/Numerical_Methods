import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        FileWriter outputFile = new FileWriter("./output.txt");


        /**
         * using bisection method to find the solutions.
         * we know there are 3 solutions and they are all between 0-4
         * first solution is between 0-1
         * second 1-2
         * third 3-4
         */
        drawLine("Bisection Method");
        testBisection(outputFile);
        /**
         * using False Position method to find the roots to the equations
         */
        drawLine("False Position Method");
        testFalsePosition(outputFile);
        /**
         * using Secant method to find the roots to the equations
         */
        drawLine("Secant Method");
        testSecantMethod(outputFile);
        /**
         * using Modified Secant method to find the roots to the equations
         */
        drawLine("Modified Secant Method");
//        testModifiedSecantMethod(outputFile);
        /**
         * using Newton's method to find the roots to the equations
         */
        drawLine("Newton Method");
        testNewtonsMethod(outputFile);
    }

    public static void testBisection(FileWriter outputFile) throws IOException {
        //This is the first equation test
        Bisection b1 = new Bisection();
        System.out.println("Solutions for the first equation: ");
        System.out.printf("The solution: %.7f\n\n", b1.solve_F1Bisection(0,1));
        System.out.printf("The solution: %.7f\n\n", b1.solve_F1Bisection(1,2));
        System.out.printf("The solution: %.7f\n", b1.solve_F1Bisection(3,4));
        System.out.println(b1.epsilonValues_Bisection.toString());

        outputFile.write("\nbisection\nFirst equation: \n");
        for (int i = 0; i <b1.epsilonValues_Bisection.size() ; i++) {
            outputFile.write(b1.epsilonValues_Bisection.get(i).toString() + "\n");
        }

        dottedLine();

        //This is the second equation test
        Bisection b2 = new Bisection();
        System.out.println("Solutions for the second equation: ");
        System.out.println("The solution: " +  b2.solve_F2Bisection(120,130));
        System.out.println();

        System.out.println(b2.epsilonValues_Bisection.toString());

        outputFile.write("second equation: \n");
        for (int i = 0; i <b2.epsilonValues_Bisection.size() ; i++) {
            outputFile.write(b2.epsilonValues_Bisection.get(i).toString() + "\n");
        }

    }

    public static void testFalsePosition(FileWriter outputFile) throws IOException {
        False_Position fs1 = new False_Position();
        System.out.println("Solutions to the first equation: ");
        System.out.printf("the solution: %.7f\n\n", fs1.solve_F1(0,1));
        System.out.printf("the solution: %.7f\n\n", fs1.solve_F1(1,2));
        System.out.printf("the solution: %.7f\n", fs1.solve_F1(3,4));

        System.out.println(fs1.epsilonValues_FalsePosition.toString());
        outputFile.write("\nFalse Position\nFirst equation: \n");
        for (int i = 0; i <fs1.epsilonValues_FalsePosition.size() ; i++) {
            outputFile.write(fs1.epsilonValues_FalsePosition.get(i).toString() + "\n");
        }

        dottedLine();

        False_Position fs2 = new False_Position();
        System.out.println("The solution to the second equation: ");
        System.out.println("The solution: " + fs2.solve_F2(120,130));

        outputFile.write("second equation: \n");
        for (int i = 0; i <fs2.epsilonValues_FalsePosition.size() ; i++) {
            outputFile.write(fs2.epsilonValues_FalsePosition.get(i).toString() + "\n");
        }

        System.out.println(fs2.epsilonValues_FalsePosition.toString());


    }

    private static void testSecantMethod(FileWriter outputFile) throws IOException {
        // here I am using values that are both located on one side of the root in order to check.
        Secant_Regular sr = new Secant_Regular();
        sr.solve_F1(-1 , 0);
        sr.solve_F1(1 , 2);
        sr.solve_F1(2.3 , 3.3);
        System.out.println(sr.epsilonValues_Secant.toString());
        outputFile.write("\nSecant Method\nFirst equation: \n");
        for (int i = 0; i <sr.epsilonValues_Secant.size() ; i++) {
            outputFile.write(sr.epsilonValues_Secant.get(i).toString() + "\n");
        }

        dottedLine();

        Secant_Regular sr2 = new Secant_Regular();
        sr2.solve_F2(120, 121);
        System.out.println(sr2.epsilonValues_Secant.toString());

        outputFile.write("second equation: \n");
        for (int i = 0; i <sr2.epsilonValues_Secant.size() ; i++) {
            outputFile.write(sr2.epsilonValues_Secant.get(i).toString() + "\n");
        }
    }

    private static void testModifiedSecantMethod(FileWriter outputFile) {
        Secant_Modified sm = new Secant_Modified();
        sm.solve_F1(0.5);

        dottedLine();

        Secant_Modified sm2 = new Secant_Modified();
        sm2.solve_F2(123);
    }
    private static void testNewtonsMethod(FileWriter outputFile) throws IOException {
        Newton_Raphson nr = new Newton_Raphson();
        nr.solve_F1(0.75);
        nr.solve_F1(1.5);
        nr.solve_F1(5.5);
        System.out.println(nr.epsilonValues_Newton.toString());
        outputFile.write("\nNewton Method\nFirst equation: \n");
        for (int i = 0; i <nr.epsilonValues_Newton.size() ; i++) {
            outputFile.write(nr.epsilonValues_Newton.get(i).toString() + "\n");
        }

        dottedLine();

        Newton_Raphson nr2 = new Newton_Raphson();
        nr2.solve_F2(123);
        System.out.println(nr2.epsilonValues_Newton.toString());

        outputFile.write("\nSecond equation: \n");
        for (int i = 0; i <nr2.epsilonValues_Newton.size() ; i++) {
            outputFile.write(nr2.epsilonValues_Newton.get(i).toString() + "\n");
        }

        outputFile.close();
    }


    //This method just draws a line
    public static void drawLine(String name){
        for (int i = 0; i <20 ; i++) {
            System.out.print("-");
        }
        System.out.printf("%S First Equation", name);

        for (int i = 0; i <20 ; i++) {
            System.out.print("-");
        }
        System.out.println();
    }
    public static void dottedLine(){
        for (int i = 0; i <20 ; i++) {
            System.out.print(".");
        }
        System.out.print("Second Equation");

        for (int i = 0; i <20 ; i++) {
            System.out.print(".");
        }
        System.out.println();
    }
}
