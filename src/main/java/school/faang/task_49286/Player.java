package school.faang.task_49286;

public class Player {
    private final Object lock = new Object();
    private boolean isPlaying = false;

    protected void play() {
        synchronized (lock) {
            if (!isPlaying) {
                isPlaying = true;
                System.out.println(Thread.currentThread().getName() + ": Воспроизведение начато.");
            } else {
                System.out.println(Thread.currentThread().getName() + ": Музыка уже играет.");

            }
        }
    }

    protected void pause() {
        synchronized (lock) {
            if (isPlaying) {
                isPlaying = false;
                System.out.println(Thread.currentThread().getName() + ": Музыка поставлена на паузу.");
            } else {
                System.out.println(Thread.currentThread().getName() + ": Музыка уже на паузе.");
            }
        }
    }

    protected void skip() {
        synchronized (lock) {
            System.out.println(Thread.currentThread().getName() + ": Трек пропущен.");
        }
    }

    protected void previous() {
        synchronized (lock) {
            System.out.println(Thread.currentThread().getName() + ": Вернулись к предыдущему треку.");
        }
    }
}

