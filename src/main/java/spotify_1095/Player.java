package spotify_1095;

import lombok.Data;

@Data
public class Player {

    private final Object lock = new Object();
    private boolean isPlaying;

    public void play() {
        synchronized (lock) {
            isPlaying = true;
            System.out.println("Воспроизведение");
            System.out.println("Музыка проигрывается - " + isPlaying());
        }
    }

    public void pause() {
        synchronized (lock) {
            isPlaying = false;
            System.out.println("Пауза");
            System.out.println("Музыка проигрывается - " + isPlaying());
        }
    }

    public void skip() {
        synchronized (lock) {
            isPlaying = false;
            System.out.println("Пропуск");
            System.out.println("Музыка проигрывается - " + isPlaying());
        }
    }

    public void previous() {
        synchronized (lock) {
            isPlaying = true;
            System.out.println("Предыдущая");
            System.out.println("Музыка проигрывается - " + isPlaying());
        }
    }
}