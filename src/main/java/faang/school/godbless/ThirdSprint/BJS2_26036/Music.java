package faang.school.godbless.ThirdSprint.BJS2_26036;

import java.util.Arrays;
import java.util.List;

public class Music {
    public static void main(String[] args) {
        List<String> songList = Arrays.asList("ELM", "Goldie", "Caravan", "Hells bells");
        int index = 1;
        Player player = new Player();

        Thread playThread = new Thread(() -> player.play());
        Thread pauseThread = new Thread(() -> player.pause());
        Thread skipThread = new Thread(() -> player.skip());
        Thread previousThread = new Thread(() -> player.previous());

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
            throw new RuntimeException(e);
        }
    }
}
