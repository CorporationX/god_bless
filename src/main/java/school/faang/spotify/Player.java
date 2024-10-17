package school.faang.spotify;

public class Player {
    private final Object lock = new Object();
    private boolean isPlaying = false;

    public void play() {
        synchronized (lock) {
            if (!isPlaying) {
                isPlaying = true;
                System.out.println("Проигрывание");
            } else {
                System.out.println("Музыка уже проигрывается");
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                isPlaying = false;
                System.out.println("Пауза.");
            } else {
                System.out.println("Уже на паузе.");
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            System.out.println("Пропустить след трек");
        }
    }

    public void previous() {
        synchronized (lock) {
            System.out.println("К предыдущему треку");
        }
    }
}
