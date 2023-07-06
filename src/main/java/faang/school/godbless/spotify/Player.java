package faang.school.godbless.spotify;

import javax.sound.midi.Soundbank;

public class Player {

    private final Object lock = new Object();
    private boolean isPlaying = false;

    public void play() {
        synchronized (lock) {
            if (!isPlaying) {
                System.out.println(Thread.currentThread().getName() + " music play");
                isPlaying = true;
            }
        }

    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                System.out.println(Thread.currentThread().getName() + " music on pause ");
                isPlaying = false;
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            System.out.println(Thread.currentThread().getName() + " next music");
        }

    }

    public void previous() {
        synchronized (lock) {
            System.out.println(Thread.currentThread().getName() + " previous music");
        }

    }
}
