package Multithreading.bc2721;

import lombok.Getter;

@Getter
public class Player {

    private final Object lock = new Object();
    private boolean isPlaying;

    public void play() {

        synchronized (lock) {
            isPlaying = true;
            System.out.println(Thread.currentThread().getName() + " Music is playing");
            lock.notifyAll();
        }
    }

    public void pause() {

        synchronized (lock) {
            isPlaying = false;
            System.out.println(Thread.currentThread().getName() + " Music on pause");
            lock.notifyAll();
        }
    }

    public void skip() {

        synchronized (lock) {
            isPlaying = true;
            System.out.println(Thread.currentThread().getName() + " Track skipped");
            lock.notifyAll();
        }
    }

    public void previous() {

        synchronized (lock) {
            isPlaying = true;
            System.out.println(Thread.currentThread().getName() + " Previous track");
            lock.notifyAll();
        }
    }
}
