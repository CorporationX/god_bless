package faang.school.godbless.spotify;

import java.util.concurrent.locks.Lock;

public class Player {
    private Object lock;
    private boolean isPlaying;

    public Player() {
        this.lock = new Object();
    }

    public void play() {
        synchronized (lock) {
            if (!isPlaying) {
                isPlaying = true;
                System.out.println("Музыка");
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                isPlaying = false;
                System.out.println("Музыка на паузе");
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            if (isPlaying) {
                isPlaying = false;
                System.out.println("Музыка пропущена");
            }
            isPlaying = true;
            System.out.println("Следующая песня");
        }
    }

    public void previous() {
        synchronized (lock) {
            if (isPlaying) {
                isPlaying = false;
                System.out.println("Песня перестала играть");
            }
            isPlaying = true;
            System.out.println("Предыдущая песня");
        }
    }
}
