package faang.school.godbless.module.third.synchronization.spotify;

public class Player {
    Object lock = new Object();
    boolean isPlaying = false;

    public void play() {
        synchronized (lock) {
            isPlaying = true;
            System.out.println("Играм трек джуси-пуси");
        }
    }

    public void pause() {
        synchronized (lock) {
            isPlaying = false;
            System.out.println("Остановили воспроизведение");
        }
    }

    public void skip() {
        synchronized (lock) {
            pause();
            System.out.println("Пропустили трек");
            play();
        }
    }

    public void previous() {
        synchronized (lock) {
            pause();
            System.out.println("Вернулись к предыдущему треку");
            play();
        }
    }
}
