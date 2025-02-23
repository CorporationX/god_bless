package school.faang.task_61904;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Music {

    public static void main(String[] args) {
        Player player = new Player();

        final Thread playThread = new Thread(() -> player.play());
        final Thread pauseThread = new Thread(() -> player.pause());
        final Thread skipThread = new Thread(() -> player.skip());
        final Thread previousThread = new Thread(() -> player.previous());

        playThread.start();
        pauseThread.start();
        skipThread.start();
        previousThread.start();

        try {
            playThread.join();
            pauseThread.join();
            skipThread.join();
            previousThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Поток прерван");
        }
    }
}
