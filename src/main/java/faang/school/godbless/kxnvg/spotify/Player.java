package faang.school.godbless.kxnvg.spotify;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Player {

    private Lock lock;
    private boolean isPlaying;

    public Player() {
        lock = new ReentrantLock();
        isPlaying = false;
    }

    public void play() {
        synchronized (lock) {
            isPlaying = true;
            System.out.println("Играет музыка...");
        }
    }

    public void pause() {
        synchronized (lock) {
            isPlaying = false;
            System.out.println("Пауза");
        }
    }

    public void skip() {
        synchronized (lock) {
            isPlaying = true;
            System.out.println("Следующий трек");
            System.out.println("Играет музыка...");
        }

    }

    public void previous() {
        synchronized (lock) {
            isPlaying = true;
            System.out.println("Предыдущий трек");
            System.out.println("Играет музыка...");
        }
    }
}
