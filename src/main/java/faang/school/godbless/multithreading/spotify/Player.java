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
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
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
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
    public void previous() {
        synchronized (lock) {
            isPlaying = true;
            System.out.println("Previous track is playing");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Player player = new Player();
        ExecutorService threadPool = Executors.newFixedThreadPool(4);

        threadPool.submit(() -> {
            try {
                Thread.sleep(500);
                player.play();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        threadPool.submit(() -> {
            try {
                Thread.sleep(1000);
                player.pause();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        threadPool.submit(() -> {
            try {
                Thread.sleep(1500);
                player.skip();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        threadPool.submit(() -> {
            try {
                Thread.sleep(2000);
                player.previous();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        threadPool.shutdown();
        threadPool.awaitTermination(5, TimeUnit.SECONDS);
    }
}

