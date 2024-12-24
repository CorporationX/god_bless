package school.faang.sprint_3.task_49405;

public class Player {
    private final Object lock = new Object();
    private boolean isPlaying = false;

    public void play() {
        synchronized (lock) {
            System.out.println(Thread.currentThread().getName()
                    + (isPlaying ? ": Музыка уже играет." : ": Музыка воспроизводится."));
            isPlaying = true;
        }
    }

    public void pause() {
        synchronized (lock) {
            System.out.println(Thread.currentThread().getName()
                    + (isPlaying ? ": Музыка поставлена на паузу." : ": Музыка уже на паузе."));
            isPlaying = false;
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
