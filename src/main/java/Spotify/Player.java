package Spotify;

import lombok.Getter;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Getter
public class Player {
    private final Lock lock = new ReentrantLock();
    private boolean isPlaying = false;

    public void play() {
        synchronized (lock) {
            if (!isPlaying) {
                isPlaying = true;
                System.out.println("Воспроизведение музыки");
            } else {
                System.out.println("Музыка уже играет");
            }
        }

    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                isPlaying = false;
                System.out.println("Музыка поставлена на паузу");
            } else {
                System.out.println("Песня на паузе");
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            System.out.println("Песня пропущена");
        }
    }

    public void previous() {
        synchronized (lock) {
            System.out.println("Вернули предыдуший трек");
        }
    }
}
