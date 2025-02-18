package bjs261657;

import java.util.ArrayList;
import java.util.List;

public class Music {
    public static void main(String[] args) {
        Player player = new Player();
        List<String> compositions = player.getCompositions();
        compositions.add("Composition1");
        compositions.add("Composition2");
        compositions.add("Composition3");
        compositions.add("Composition4");

        List<Thread> threads = new ArrayList<>();

        Thread playThread1 = new Thread(() -> {
            try {
                player.play();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        threads.add(playThread1);
        Thread playThread2 = new Thread(() -> {
            try {
                player.play();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        threads.add(playThread2);

        Thread pauseThread1 = new Thread(() -> {
            try {
                player.pause();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        threads.add(pauseThread1);
        Thread pauseThread2 = new Thread(() -> {
            try {
                player.pause();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        threads.add(pauseThread2);

        Thread skipThread1 = new Thread(() -> {
            try {
                player.skip();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        threads.add(skipThread1);
        Thread skipThread2 = new Thread(() -> {
            try {
                player.skip();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        threads.add(skipThread2);

        Thread previousThread1 = new Thread(() -> {
            try {
                player.previous();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        threads.add(previousThread1);
        Thread previousThread2 = new Thread(() -> {
            try {
                player.previous();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        threads.add(previousThread2);

        threads.forEach(Thread::start);

        threads.forEach(thread -> {
            try {
                thread.join(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
