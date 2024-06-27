package faang.school.godbless.sprint_3.multithreading_synchronization.task_1_spotify;

public class Player {
    private static final Object lock = new Object();
    private Boolean isPlaying;

    public Player() {
        this.isPlaying = false;
    }

    public void play() {
        synchronized (lock) {
            if (!isPlaying) {
                isPlaying = !isPlaying;
                System.out.println(Thread.currentThread().getName() + ": включил плеер.");
            } else {
                System.out.println(Thread.currentThread().getName() + ": повторно жмёт \"play\".");
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                isPlaying = !isPlaying;
                System.out.println(Thread.currentThread().getName() + ": поставил плеер на паузу.");
            } else {
                System.out.println(Thread.currentThread().getName() + ": повторно жмёт \"pause\".");
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            System.out.print(Thread.currentThread().getName() + ": пропустил трек. ");
            if (isPlaying) {
                System.out.println("Плеер продолжает проигрывать музыку.");
            } else {
                System.out.println("Плеер всё ещё на пуазу.");
            }
        }
    }

    public void previous() {
        synchronized (lock) {
            System.out.print(Thread.currentThread().getName() + ": включил предыдущий трек. ");
            if (isPlaying) {
                System.out.println("Плеер продолжает проигрывать музыку.");
            } else {
                System.out.println("Плеер всё ещё на пуазу.");
            }
        }
    }
}
