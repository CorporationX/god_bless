package faang.school.godbless.alexbulgakoff.multithreading.synchronization.spotify;

import lombok.Getter;
import lombok.ToString;

/**
 * @author Alexander Bulgakov
 */

@Getter
@ToString
public class Player {
    private final Object lock;
    private boolean isPlaying;

    public Player() {
        lock = new Object();
        isPlaying = false;
    }

    public void play() {
        synchronized (lock) {
            System.out.println("Композиция проигрывается в " + Thread.currentThread().getName());
            isPlaying = true;
        }
    }
    public void pause() {
        synchronized (lock) {
            System.out.println("Композиция на паузе в " + Thread.currentThread().getName());
            isPlaying = false;
        }
    }
    public void skip() {
        synchronized (lock) {
            System.out.println("Композиция пропускается в " + Thread.currentThread().getName());
            isPlaying = false;
        }
    }
    public void previous() {
        synchronized (lock) {
            System.out.println("Играет предыдущая композиция в " + Thread.currentThread().getName());
            isPlaying = true;
        }
    }
}
