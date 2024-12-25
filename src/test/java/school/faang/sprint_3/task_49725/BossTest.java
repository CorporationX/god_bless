package school.faang.sprint_3.task_49725;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class BossTest {

    @Test
    void testMaxPlayersLimit() throws InterruptedException {
        Boss boss = new Boss(3);
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        IntStream.range(1, 11)
                .mapToObj(i -> new Player(i, boss))
                .forEach(executorService::execute);

        executorService.shutdown();
        while (!executorService.isTerminated()) {
            Thread.sleep(100);
        }

        assertEquals(0, getFieldCurrentPlayer(boss));
    }

    @Test
    void testPlayerWaitsWhenSlotsAreFull() throws InterruptedException {
        Boss boss = new Boss(1); // Только 1 слот
        Player player1 = new Player(1, boss);
        Player player2 = new Player(2, boss);

        Thread thread1 = new Thread(player1);
        Thread thread2 = new Thread(player2);

        thread1.start();
        Thread.sleep(100);
        thread2.start();

        thread1.join();
        thread2.join();

        assertEquals(0, getFieldCurrentPlayer(boss));
    }

    @Test
    void testPlayerJoinsAndLeavesCorrectly() throws InterruptedException {
        Boss boss = new Boss(3);
        Player player = new Player(1, boss);

        Thread thread = new Thread(player);
        thread.start();
        thread.join();

        assertEquals(0, getFieldCurrentPlayer(boss));
    }

    private int getFieldCurrentPlayer(Boss boss) {
        try {
            var field = Boss.class.getDeclaredField("currentPlayer");
            field.setAccessible(true);
            return field.getInt(boss);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
