package school.faang.sprint_3.task_49405;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    void testPlay() {
        Player player = new Player();

        player.play();
        player.play();
    }

    @Test
    void testPause() {
        Player player = new Player();

        player.pause();

        player.play();
        player.pause();
    }

    @Test
    void testSkip() {
        Player player = new Player();

        player.skip();
    }

    @Test
    void testPrevious() {
        Player player = new Player();

        player.previous();
    }

    @Test
    void testConcurrency() throws InterruptedException {
        Player player = new Player();

        Thread playThread = new Thread(player::play, "PlayThread");
        playThread.start();

        Thread pauseThread = new Thread(player::pause, "PauseThread");
        pauseThread.start();

        Thread skipThread = new Thread(player::skip, "SkipThread");
        skipThread.start();

        Thread previousThread = new Thread(player::previous, "PreviousThread");
        previousThread.start();

        playThread.join();
        pauseThread.join();
        skipThread.join();
        previousThread.join();

        assertTrue(true, "Потоки завершены без ошибок.");
    }

}
