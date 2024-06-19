package faang.school.godbless.spotify;

import lombok.SneakyThrows;

public class Player {
    private final static Object lock = new Object();
    private boolean isPlaying = false;

    @SneakyThrows
    public void play() {
        synchronized (lock) {
            isPlaying = true;
            Thread.sleep(5000);
            System.out.println("play");
            isPlaying = false;
        }
    }

    @SneakyThrows
    public void pause() {
        synchronized (lock) {
            isPlaying = true;
            Thread.sleep(5000);
            System.out.println("pause");
            isPlaying = false;
        }
    }

    @SneakyThrows
    public void skip() {
        synchronized (lock) {
            isPlaying = true;
            Thread.sleep(5000);
            System.out.println("skip");
            isPlaying = false;
        }
    }

    @SneakyThrows
    public void previous() {
        synchronized (lock) {
            isPlaying = true;
            Thread.sleep(5000);
            System.out.println("previous");
            isPlaying = false;
        }
    }
}
