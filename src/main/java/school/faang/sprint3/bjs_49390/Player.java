package school.faang.sprint3.bjs_49390;

public class Player {
    private final Object lock = new Object();
    private boolean isPlaying;

    public void play() {
        synchronized (lock) {
            if (!isPlaying) {
                isPlaying = true;
                System.out.println("Началось воспроизведение музыки");
            } else {
                System.out.println("Музыка уже воспроизводится");
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                isPlaying = false;
                System.out.println("Воспроизведение приостановлено");
            } else {
                System.out.println("Воспроизведение уже остановлено");
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            System.out.println("Переключение на следующую композицию");
        }
    }

    public void previous() {
        synchronized (lock) {
            System.out.println("Переключение на предыдущую композицию");
        }
    }
}
