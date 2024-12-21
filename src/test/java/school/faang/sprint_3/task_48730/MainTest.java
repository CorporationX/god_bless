package school.faang.sprint_3.task_48730;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static org.junit.jupiter.api.Assertions.assertTrue;

class MainTest {

    @Test
    void testMainExecution() throws ExecutionException, InterruptedException {
        final int amountOfThreads = 5;
        final int totalEmails = 1000;
        final int emailsPerThread = totalEmails / amountOfThreads;

        ExecutorService executorService = Executors.newFixedThreadPool(amountOfThreads);

        for (int i = 0; i < amountOfThreads; i++) {
            int startIndex = i * emailsPerThread + 1;
            int endIndex = startIndex + emailsPerThread;

            SenderRunnable task = new SenderRunnable(startIndex, endIndex);
            Future<String> future = executorService.submit(task);
            String result = future.get();

            assertTrue(result.startsWith("Письма отправлены: " + startIndex));
            assertTrue(result.endsWith(String.valueOf(endIndex - 1)));
        }

        executorService.shutdown();
    }
}