import org.junit.jupiter.api.Test;
import school.faang.bjs248406.SenderRunnable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SenderRunnableTest {
    @Test
    public void testThreadExecutions() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        executorService.submit(new SenderRunnable(0, 200));
        executorService.submit(new SenderRunnable(201, 400));
        executorService.submit(new SenderRunnable(401, 600));
        executorService.submit(new SenderRunnable(601, 800));
        executorService.submit(new SenderRunnable(801, 1000));

        executorService.shutdown();

        boolean executorFinish = executorService.awaitTermination(5, TimeUnit.SECONDS);

        assertTrue(executorFinish, "Not all threads in time");
    }
}
