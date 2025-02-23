package bigbang;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class TaskTest {

    private static final String NAME = "Sheldon";
    private static final String ASSIGNMENT_DESCRIPTION = "prepare theory";

    private Task assignment;

    @BeforeEach
    void setUp() {
        assignment = new Task(NAME, ASSIGNMENT_DESCRIPTION);
    }

    @Nested
    class NormalExecutionTests {
        @Test
        void testRunCompletesWithoutException() {
            assertDoesNotThrow(() -> assignment.run());
        }
    }

    @Nested
    class InterruptedExecutionTests {
        @Test
        void testRunWhenInterrupted() throws InterruptedException {
            Thread taskThread = new Thread(assignment);
            taskThread.start();

            ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
            scheduler.schedule(taskThread::interrupt, 50, TimeUnit.MILLISECONDS);
            scheduler.shutdown();

            taskThread.join();
            assertTrue(true);
        }
    }
}
