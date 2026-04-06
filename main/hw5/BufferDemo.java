public class BufferDemo {
    public static void main(String[] args) throws InterruptedException {
        SingleSlotBuffer<Integer> buffer = new SingleSlotBuffer<>();
        long expectedSum = 1000L * 1001 / 2;

        Thread producer = new Thread(() -> {
            try {
                for (int i = 1; i <= 1000; i++) {
                    buffer.put(i);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread consumer = new Thread(() -> {
            try {
                long sum = 0;
                for (int i = 0; i < 1000; i++) {
                    sum += buffer.take();
                }
                System.out.println("Sum: " + sum + ", Expected: " + expectedSum);
                System.out.println("Test " + (sum == expectedSum ? "PASSED" : "FAILED"));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        producer.start();
        consumer.start();
        producer.join();
        consumer.join();
    }
}