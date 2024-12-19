package school.faang.task_49185;

import java.util.List;

public class Music {
    public static void main(String[] args) {
        Player player = new Player();
        Thread threadPlay = new Thread(() -> player.play());
        threadPlay.start();

        Thread threadSkip = new Thread(() -> player.skip());
        threadSkip.start();

        Thread threadPrevious = new Thread(() -> player.previous());
        threadPrevious.start();

        Thread threadPause = new Thread(() -> player.pause());
        threadPause.start();
    }
}
