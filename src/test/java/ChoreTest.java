import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import school.faang.bjs248493.Chore;
import school.faang.bjs248493.WeasleyFamily;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ChoreTest {

    @Test
    public void testExecutorServiceCompletedAllTasks() throws InterruptedException {
        String[] chores = {"wash the dishes", "sweep the floor", "cook dinner"};
        ExecutorService executorService = Executors.newCachedThreadPool();
        CountDownLatch countDownLatch = new CountDownLatch(3);

        for (int i = 0; i < chores.length; i++) {
            executorService.submit(new Chore(chores[i], countDownLatch));
        }
        executorService.shutdown();

        boolean allThreadsCompeted = countDownLatch.await(5, TimeUnit.SECONDS);
        Assertions.assertTrue(allThreadsCompeted, "Not all threads completed on time");
        Assertions.assertEquals(0, countDownLatch.getCount(), "Latch count should be 0, when all threads are done");
    }
}
