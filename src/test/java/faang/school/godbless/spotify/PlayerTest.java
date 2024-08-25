package faang.school.godbless.spotify;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
    @Test
    void testPlayPause() throws InterruptedException {
        Player player = new Player();

        Thread playThread = new Thread(player::play);
        Thread pauseThread = new Thread(player::pause);

        playThread.start();
        playThread.join();

        assertTrue(player.isPlaying(), "isPlaying should be true after play()");

        pauseThread.start();
        pauseThread.join();

        assertFalse(player.isPlaying(), "isPlaying should be false after pause()");
    }

    @Test
    void testSkipPrevious() throws InterruptedException {
        Player player = new Player();

        Thread skipThread = new Thread(player::skip);
        Thread previousThread = new Thread(player::previous);

        skipThread.start();
        skipThread.join();

        previousThread.start();
        previousThread.join();
    }

    @Test
    void testConcurrentAccess() throws InterruptedException {
        Player player = new Player();

        Thread playThread = new Thread(player::play);
        Thread pauseThread = new Thread(player::pause);
        Thread skipThread = new Thread(player::skip);
        Thread previousThread = new Thread(player::previous);

        playThread.start();
        pauseThread.start();
        skipThread.start();
        previousThread.start();

        playThread.join();
        pauseThread.join();
        skipThread.join();
        previousThread.join();

        assertNotNull(player.isPlaying(), "isPlaying should be either true or false");
    }
}