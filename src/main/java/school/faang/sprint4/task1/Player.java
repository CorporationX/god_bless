package school.faang.sprint4.task1;

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

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                isPlaying = false;
                System.out.println("Музыка на паузе.");
            } else {
                System.out.println("Музыка уже приостановлена.");
            }
        }

    }

    public void skip() {
        synchronized (lock) {
            synchronized (lock) {
                System.out.println("Трек пропущен.");
            }

        }
    }

    public void previous() {
        synchronized (lock) {
            synchronized (lock) {
                System.out.println("Включен предыдущий трек.");
            }
        }
    }
}
