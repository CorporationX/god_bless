package school.faang.java.thread1.spotify;

import lombok.Data;

@Data
public class Player {

    public static final int DELAY = 30;

    private final Object lock = new Object();
    private boolean isPlaying = false;

    public void play(String userName) {
        System.out.println("Хочу Bоспроизведение музыки  " + userName);
        synchronized (lock) {
            System.out.println("Bоспроизведение музыки " + userName);
            delay();
            isPlaying = true;
        }
    }

    public void pause(String userName) {
        System.out.println("Хочу поставить на паузу " + userName);
        synchronized (lock) {
            System.out.println("Поставить на паузу  " + userName);
            delay();
            isPlaying = false;
        }
    }

    public void skip(String userName) {
        System.out.println("Хочу пропустить трек  " + userName);
        synchronized (lock) {
            System.out.println("Пропустить трек " + userName);
            delay();
            isPlaying = false;
        }
    }

    public void previous(String userName) {
        System.out.println("Хочу вернуться к предыдущему треку  " + userName);
        synchronized (lock) {
            System.out.println("Вернуться к предыдущему треку  " + userName);
            delay();
            isPlaying = false;
        }
    }

    void delay() {
        try {
            Thread.sleep(Player.DELAY);
        } catch (InterruptedException e) {
            throw new IllegalArgumentException("ESP0001.012 IllegalArgumentException");
        }
    }
}