package faang.school.godbless.spotify;

import lombok.SneakyThrows;

public class Player {
    private final static Object lock = new Object();
    private volatile boolean isPlaying = false;

    @SneakyThrows
    public void play() {
        synchronized (lock) {
            isPlaying = true;
            Thread.sleep(5000);
            System.out.println("play");
        }
    }

    @SneakyThrows
    public void pause() {
        synchronized (lock) {
            isPlaying = false;
            Thread.sleep(5000);
            System.out.println("pause");
        }
    }

    @SneakyThrows
    public void skip() {
        synchronized (lock) {
            isPlaying = true;
            Thread.sleep(5000);
            System.out.println("skip");
        }
    }

    @SneakyThrows
    public void previous() {
        synchronized (lock) {
            isPlaying = true;
            Thread.sleep(5000);
            System.out.println("previous");
        }
    }
}
