package faang.school.godbless.BJS2_24360;

import java.util.List;

public class Music {

    public static void main(String[] args) throws InterruptedException {
        Player player = new Player();
        Thread playTread = new Thread(() -> player.play());
        Thread pauseThread = new Thread(() -> player.pause());
        Thread skipThread = new Thread(() -> player.skip());
        Thread previousThread = new Thread(() -> player.previous());

        List<Thread> list = List.of(playTread, pauseThread, skipThread, previousThread);
        for (Thread thread : list) {
            thread.start();
        }

        playTread.join();
        pauseThread.join();
        skipThread.join();
        previousThread.join();
    }
}
