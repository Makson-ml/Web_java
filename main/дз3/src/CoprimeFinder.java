import java.util.List;
import java.util.Arrays;

public class CoprimeFinder {

    public static int gcd(int a, int b) {
        if (a < 0 || b < 0) 
            throw new IllegalArgumentException("Numbers must be non-negative");
        
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static boolean isCoprimeWithAll(int num, List<Integer> divisors) {
        for (int d : divisors) {
            if (gcd(num, d) != 1) return false;
        }
        return true;
    }

    public static <T> int findFirstMatch(List<T> source, int from, int to, UnaryPredicate<T> condition) {
        for (int i = from; i < to; i++) {
            if (condition.test(source.get(i))) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        List<Integer> candidates = Arrays.asList(10, 5, 21, 34);
        List<Integer> base = Arrays.asList(2, 7);
        
        UnaryPredicate<Integer> predicate = n -> isCoprimeWithAll(n, base);
        int result = findFirstMatch(candidates, 0, candidates.size(), predicate);
        
        System.out.println(result == 1 ? "Test 1 PASSED" : "Test 1 FAILED");

        List<Integer> noMatch = Arrays.asList(4, 6, 8);
        List<Integer> base2 = Arrays.asList(2);
        UnaryPredicate<Integer> pred2 = n -> isCoprimeWithAll(n, base2);
        int res2 = findFirstMatch(noMatch, 0, noMatch.size(), pred2);
        
        System.out.println(res2 == -1 ? "Test 2 PASSED" : "Test 2 FAILED");
    }
}
