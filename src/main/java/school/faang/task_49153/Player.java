package school.faang.task_49153;

public class Player {
    private final Object lock = new Object();
    private boolean isPlaying = false;

    public void play() {
        synchronized (lock) {
            if (!isPlaying) {
                isPlaying = true;
                System.out.println("Музыка воспроизводится");
            } else {
                System.out.println("Музыка уже играет");
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                isPlaying = false;
                System.out.println("Музыка остановлена");
            } else {
                System.out.println("Музыка уже была остановлена");
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            System.out.println("Трек пропущен");
        }
    }

    public void previous() {
        synchronized (lock) {
            System.out.println("Вы вернулись к предыдущему треку");
        }
    }
}
