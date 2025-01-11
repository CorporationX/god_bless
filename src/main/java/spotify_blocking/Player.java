package spotify_blocking;

import lombok.Getter;
@Getter
public class Player {
    private final Object lock = new Object();
    private boolean isPlaying;

    public void play() {
        synchronized (lock) {
            if (!isPlaying) {
                isPlaying = true;
                System.out.println("Музыка начала играть");
            } else {
                System.out.println("Музыка уже играет");
            }
        }
    }


    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                isPlaying = false;
                System.out.println("Музыка на паузе");
            } else {
                System.out.println("Музыка находилась на паузе");
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            System.out.println("переключаем на следующзий трек");
        }
    }

    public void previous() {
        synchronized (lock) {
            System.out.println("предыдущий трек включен");
        }
    }
}
