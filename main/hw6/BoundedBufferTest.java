import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import static org.junit.jupiter.api.Assertions.*;

class BoundedBufferTest {
    private BoundedBuffer<Integer> buffer;

    @BeforeEach
    void setUp() {
        buffer = new BoundedBuffer<>(10);
    }

    @Test
    @Timeout(value = 30, unit = TimeUnit.SECONDS)
    void testProducerConsumer_SumVerification() throws InterruptedException {
        AtomicLong sum = new AtomicLong(0);
        long expectedSum = 1000L * 1001 / 2;
        ExecutorService executor = Executors.newFixedThreadPool(2);

        executor.submit(() -> {
            try {
                for (int i = 1; i <= 1000; i++) {
                    buffer.put(i);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        executor.submit(() -> {
            try {
                for (int i = 0; i < 1000; i++) {
                    Integer value = buffer.take();
                    assertNotNull(value);
                    sum.addAndGet(value);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        executor.shutdown();
        assertTrue(executor.awaitTermination(1, TimeUnit.MINUTES));
        assertEquals(expectedSum, sum.get());
    }

    @Test
    @Timeout(value = 30, unit = TimeUnit.SECONDS)
    void testMultipleProducersConsumers() throws InterruptedException {
        int producers = 2;
        int consumers = 2;
        int itemsPerProducer = 500;
        AtomicLong sum = new AtomicLong(0);
        long expectedSum = (long) itemsPerProducer * (itemsPerProducer + 1) / 2 * producers;
        ExecutorService executor = Executors.newFixedThreadPool(producers + consumers);

        for (int p = 0; p < producers; p++) {
            final int offset = p * itemsPerProducer;
            executor.submit(() -> {
                try {
                    for (int i = 1; i <= itemsPerProducer; i++) {
                        buffer.put(offset + i);
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
        }

        for (int c = 0; c < consumers; c++) {
            executor.submit(() -> {
                try {
                    for (int i = 0; i < itemsPerProducer; i++) {
                        Integer value = buffer.take();
                        if (value != null) sum.addAndGet(value);
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
        }

        executor.shutdown();
        assertTrue(executor.awaitTermination(2, TimeUnit.MINUTES));
        assertEquals(expectedSum, sum.get());
    }

    @Test
    void testInterruptedException_NotSwallowed() {
        assertThrows(InterruptedException.class, () -> {
            BoundedBuffer<Integer> small = new BoundedBuffer<>(1);
            small.put(1);
            Thread.currentThread().interrupt();
            small.put(2);
        });
        Thread.interrupted();
    }
}
