package faang.school.godbless.multithreading.spotify;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Player {
    public final Object lock = new Object();
    public boolean isPlaying;
    public void play() {
        synchronized (lock) {
            if (!isPlaying) {
                isPlaying = true;
                System.out.println("Music is playing.");
                sleep(2000);
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                isPlaying = false;
                System.out.println("Music is paused.");
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            isPlaying = true;
            System.out.println("Next track is playing");
            sleep(1000);
        }
    }
    public void previous() {
        synchronized (lock) {
            isPlaying = true;
            System.out.println("Previous track is playing");
            sleep(1000);
        }
    }
    public static void main(String[] args) throws InterruptedException {
        Player player = new Player();
        ExecutorService threadPool = Executors.newFixedThreadPool(4);

        threadPool.submit(() -> {
            sleep(500);
            player.play();
        });

        threadPool.submit(() -> {
            sleep(1000);
            player.pause();
        });

        threadPool.submit(() -> {
            sleep(1500);
            player.skip();
        });

        threadPool.submit(() -> {
            sleep(2000);
            player.previous();

        });

        threadPool.shutdown();
        threadPool.awaitTermination(5, TimeUnit.SECONDS);
    }

    private static void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }


}

