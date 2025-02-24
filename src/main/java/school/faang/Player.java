package school.faang;

public class Player {

    private final Object lock = new Object();
    private boolean isPlaying = false;

    public boolean isPlaying() {
        return isPlaying;
    }

    public void play() {
        if (lock == null) {
            throw new IllegalStateException("Lock object is null");
        }
        synchronized (lock) {
            if (!isPlaying()) {
                isPlaying = true;
                System.out.println("Музыка воспроизводится");
            } else {
                System.out.println("Музыка уже воспроизвоится");
            }
        }
    }

    public void pause() {
        if (lock == null) {
            throw new IllegalStateException("Lock object is null");
        }
        synchronized (lock) {
            if (isPlaying()) {
                isPlaying = false;
                System.out.println("Воспроизведение приостановлено");
            } else {
                System.out.println("Воспроизведение уже приостановлено");
            }
        }
    }

    public void skip() {
        if (lock == null) {
            throw new IllegalStateException("Lock object is null");
        }
        synchronized (lock) {
            System.out.println("Трек пропущен");
        }
    }

    public void previous() {
        if (lock == null) {
            throw new IllegalStateException("Lock object is null");
        }
        synchronized (lock) {
            System.out.println("Возвращение к предыдущему треку");
        }
    }

}

