package school.faang.sprint_3.task_48730;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SenderRunnableTest {

    @Test
    void testCallSingleRange() throws ExecutionException, InterruptedException {
        SenderRunnable senderRunnable = new SenderRunnable(1, 6);
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Future<String> future = executorService.submit(senderRunnable);
        String result = future.get();
        executorService.shutdown();

        assertEquals("Письма отправлены: 1 2 3 4 5", result);
    }

    @Test
    void testCallEmptyRange() throws ExecutionException, InterruptedException {
        SenderRunnable senderRunnable = new SenderRunnable(10, 10);
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Future<String> future = executorService.submit(senderRunnable);
        String result = future.get();
        executorService.shutdown();

        assertEquals("Письма отправлены:", result);
    }

    @Test
    void testCallLargeRange() throws ExecutionException, InterruptedException {
        SenderRunnable senderRunnable = new SenderRunnable(1, 1001);
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Future<String> future = executorService.submit(senderRunnable);
        String result = future.get();
        executorService.shutdown();

        assertEquals(true, result.startsWith("Письма отправлены: 1 2 3"));
        assertEquals(true, result.endsWith("999 1000"));
    }
}