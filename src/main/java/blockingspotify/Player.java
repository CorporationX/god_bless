package blockingspotify;

import lombok.Data;

@Data
public class Player {
    private final Object lock = new Object();
    private boolean isPlaying;

    public void play() {
        synchronized (lock) {
            if (!isPlaying) {
                isPlaying = true;
                System.out.println("Музыка играет");
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
                System.out.println("Музыка уже на паузе");
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            System.out.println("Трек пропущен");
        }
    }

    public void previous() {
        synchronized (lock) {
            System.out.println("Вернулись к предыдущему треку");
        }
    }
}
