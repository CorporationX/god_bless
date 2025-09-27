package school.faang.bjs2_90525;

public class Player {
    private final Object lock = new Object();
    private boolean isPlaying;

    public void play() {
        synchronized (lock) {
            if (!isPlaying) {
                isPlaying = true;
                System.out.println("Трек воспроизводится.");
            } else {
                System.out.println("Трек уже воспроизводится");
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                isPlaying = false;
                System.out.println("Трек на паузе.");
            } else {
                System.out.println("Трек уже на паузе.");
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            isPlaying = true;
            System.out.println("Пропуск трека.");
        }
    }

    public void previous() {
        synchronized (lock) {
            System.out.println("Возвращение к предыдущему треку.");
        }
    }
}
