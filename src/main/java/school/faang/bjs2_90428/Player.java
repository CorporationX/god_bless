package school.faang.bjs2_90428;

public class Player {
    private final Object lock = new Object();
    private boolean isPlaying = false;

    public void play() {
        synchronized (lock) {
            if (!isPlaying) {
                System.out.println("Возпроизвести трек");
                isPlaying = true;
            } else {
                System.out.println("Трек уже воспроизводится");
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                System.out.println("Остановить трек");
                isPlaying = false;
            } else {
                System.out.println("Трек уже остановлен");
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            System.out.println("Пропустить трек");
        }
    }

    public void previous() {
        synchronized (lock) {
            System.out.println("Вернуться к предыдущему треку");
        }
    }
}
