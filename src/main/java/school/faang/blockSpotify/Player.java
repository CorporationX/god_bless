package school.faang.blockSpotify;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Player {

    private Object lock = new Object();
    private Boolean isPlaying = false;

    public void play() {
        synchronized (lock) {
            if (!isPlaying) {
                isPlaying = true;
                System.out.printf("[Поток %s] снял музыку с паузы%n", Thread.currentThread().getName());
            } else {
                System.out.printf("[Поток %s] музыка уже играет%n", Thread.currentThread().getName());
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                isPlaying = false;
                System.out.printf("[Поток %s] поставил музыку на паузу%n", Thread.currentThread().getName());
            } else {
                System.out.printf("[Поток %s] музыка уже стоит на паузе%n", Thread.currentThread().getName());
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            System.out.printf("[Поток %s] включил следующий трек%n", Thread.currentThread().getName());
        }
    }

    public void previous() {
        synchronized (lock) {
            System.out.printf("[Поток %s] включил предыдущий трек", Thread.currentThread().getName());
        }
    }
}