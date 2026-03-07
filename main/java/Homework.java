import java.util.function.DoubleUnaryOperator;

public class Homework {

    private static double calcIntegral(double a, double b, 
                                       DoubleUnaryOperator function, 
                                       double delta) {
        if (delta <= 0) {
            throw new IllegalArgumentException("delta must be > 0");
        }
        if (a > b) {
            throw new IllegalArgumentException("a must be <= b");
        }

        double sum = 0.0;
        double x = a;
        
        while (x < b) {
            double nextX = x + delta;
            if (nextX > b) {
                nextX = b;
            }
            double width = nextX - x;
            sum += function.applyAsDouble(x) * width;
            x = nextX;
        }
        
        return sum;
    }

    public static void main(String[] args) {
        System.out.println("=== Integral Tests ===");
        
        double res1 = calcIntegral(1, 2, x -> x * 2, 0.1);
        System.out.println("Integral of 2x from 1 to 2: " + res1);
        System.out.println("Expected ~3.0, close enough: " + (Math.abs(res1 - 3.0) < 0.1));
        
        double res2 = calcIntegral(0, 5, x -> 1.0, 0.5);
        System.out.println("\nIntegral of 1 from 0 to 5: " + res2);
        System.out.println("Expected ~5.0, close enough: " + (Math.abs(res2 - 5.0) < 0.01));
        
        double res3 = calcIntegral(0, 10, x -> x, 0.01);
        System.out.println("\nIntegral of x from 0 to 10: " + res3);
        System.out.println("Expected ~50.0, close enough: " + (Math.abs(res3 - 50.0) < 0.1));
        
        System.out.println("\n--- Test bad delta ---");
        try {
            calcIntegral(0, 1, x -> x, -0.1);
            System.out.println("ERROR: should have thrown");
        } catch (IllegalArgumentException e) {
            System.out.println("OK: " + e.getMessage());
        }
        
        System.out.println("\n--- Test a > b ---");
        try {
            calcIntegral(5, 3, x -> x, 0.1);
            System.out.println("ERROR: should have thrown");
        } catch (IllegalArgumentException e) {
            System.out.println("OK: " + e.getMessage());
        }
        
        System.out.println("\n=== All Integral tests done ===");
    }
}
