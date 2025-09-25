package school.faang.bjs2_90472_Spotify;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Player {
    private final Lock lock = new ReentrantLock();
    private boolean isPlaying;

    public void play() {
        lock.lock();
        try {
            System.out.println("Начал воспроизведение музыки");
            isPlaying = true;
        } finally {
            lock.unlock();
        }
    }

    public void pause() {
        lock.lock();
        try {
            System.out.println("Ставлю трек на паузу");
            isPlaying = false;
        } finally {
            lock.unlock();
        }
    }

    public void skip() {
        lock.lock();
        try {
            System.out.println("Пропускаю трек");
            isPlaying = true;
        } finally {
            lock.unlock();
        }
    }

    public void previous() {
        lock.lock();
        try {
            System.out.println("Возвращаюсь к предыдущему треку");
            isPlaying = true;
        } finally {
            lock.unlock();
        }
    }
}