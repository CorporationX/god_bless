package threadtwo.one;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Player {

    private final Object lock = new Object();

    private boolean isPlaying;

    public void play() {
        synchronized (lock) {
            isPlaying = true;
            System.out.println("Музыка играет.");
        }
    }

    public void pause() {
        synchronized (lock) {
            isPlaying = false;
            System.out.println("Музыка на паузе.");
        }
    }

    public void skip() {
        synchronized (lock) {
            System.out.println("Заиграл следующий трек.");
        }
    }

    public void previous() {
        synchronized (lock) {
            System.out.println("Заиграл предыдущий трек.");
        }
    }
}
