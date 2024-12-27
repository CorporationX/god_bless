package school.faang.task_49450;

public class Player {

    private final Object lock = new Object();
    private boolean isPlaying = false;

    public void play() {
        synchronized (lock) {
            if (!isPlaying) {
                isPlaying = true;
                System.out.println("Музыка воспроизводится.");
            } else {
                System.out.println("Музыка уже играет.");
            }
        }
    }

    public synchronized void pause() {
        synchronized (lock) {
            if (isPlaying) {
                isPlaying = false;
                System.out.println("Музыка поставлена на паузу.");
            } else {
                System.out.println("Музыка уже на паузе.");
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            System.out.println("Трек пропущен.");
        }
    }

    public void previous() {
        synchronized (lock) {
            System.out.println("Вернулись к предыдущему треку.");
        }
    }
}
