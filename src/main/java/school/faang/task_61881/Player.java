package school.faang.task_61881;

public class Player {
    private final Object lock = new Object();

    private boolean isPlaying = false;

    public void play() {
        synchronized (lock) {
            if (!isPlaying) {
                isPlaying = true;
                System.out.println("Воспроизведение трека");
            } else {
                System.out.println("Трек уже запущен");
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                isPlaying = false;
                System.out.println("Приостановка трека");
            } else {
                System.out.println("Трек уже приостановлен");
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            System.out.println("Пропуск трека");
        }
    }

    public void previous() {
        synchronized (lock) {
            System.out.println("Воспроизведение предыдущего трека");
        }
    }
}
