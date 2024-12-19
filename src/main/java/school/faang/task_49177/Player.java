package school.faang.task_49177;

public class Player {
    private final Object lock = new Object();
    private boolean isPlaying = false;

    public void play() {
        synchronized (lock) {
            if (!isPlaying) {
                isPlaying = true;
                System.out.println(Thread.currentThread().getName() + ": Музыка воспроизводится.");
            } else {
                System.out.println(Thread.currentThread().getName() + ": Музыка уже играет.");
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                isPlaying = false;
                System.out.println(Thread.currentThread().getName() + ": Музыка поставлена на паузу.");
            } else {
                System.out.println(Thread.currentThread().getName() + ": Музыка уже на паузе.");
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            System.out.println(Thread.currentThread().getName() + ": Трек пропущен.");
        }
    }

    public void previous() {
        synchronized (lock) {
            System.out.println(Thread.currentThread().getName() + ": Вернулись к предыдущему треку.");
        }
    }
}