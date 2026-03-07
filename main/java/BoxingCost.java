public class BoxingCost {

    public static long sumWithBoxing(Integer[] values) {
        if (values == null) {
            throw new IllegalArgumentException("Array is null");
        }
        long sum = 0;
        for (Integer value : values) {
            if (value == null) {
                throw new IllegalArgumentException("Element is null");
            }
            sum += value;
        }
        return sum;
    }

    public static long sumWithoutBoxing(int[] values) {
        if (values == null) {
            throw new IllegalArgumentException("Array is null");
        }
        long sum = 0;
        for (int value : values) {
            sum += value;
        }
        return sum;
    }

    public static int[] toIntArray(Integer[] values) {
        if (values == null) {
            throw new IllegalArgumentException("Array is null");
        }
        int[] result = new int[values.length];
        for (int i = 0; i < values.length; i++) {
            if (values[i] == null) {
                throw new IllegalArgumentException("Element at " + i + " is null");
            }
            result[i] = values[i];
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("=== BoxingCost Tests ===");
        
        Integer[] boxed = {10, 20, 30};
        int[] primitive = toIntArray(boxed);
        
        long sum1 = sumWithBoxing(boxed);
        long sum2 = sumWithoutBoxing(primitive);
        
        System.out.println("sumWithBoxing: " + sum1);
        System.out.println("sumWithoutBoxing: " + sum2);
        System.out.println("Sums equal: " + (sum1 == sum2));
        
        System.out.println("\n--- Test null in toIntArray ---");
        try {
            Integer[] bad = {1, null, 3};
            toIntArray(bad);
            System.out.println("ERROR: should have thrown exception");
        } catch (IllegalArgumentException e) {
            System.out.println("OK: " + e.getMessage());
        }
        
        System.out.println("\n--- Test null in sumWithBoxing ---");
        try {
            Integer[] bad = {1, null, 3};
            sumWithBoxing(bad);
            System.out.println("ERROR: should have thrown exception");
        } catch (IllegalArgumentException e) {
            System.out.println("OK: " + e.getMessage());
        }
        
        System.out.println("\n=== All BoxingCost tests done ===");
    }
}
