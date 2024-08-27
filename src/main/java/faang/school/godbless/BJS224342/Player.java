package faang.school.godbless.BJS224342;

public class Player {
    private final Object lock = new Object();  // Объект блокировки
    private boolean isPlaying = false;  // Состояние воспроизведения

    public void play() {
        synchronized (lock) {
            if (!isPlaying) {
                isPlaying = true;
                System.out.println("Playing...");
            } else {
                System.out.println("Already playing...");
            }
        }
    }

    public void pause() {
        synchronized (lock) {
        if (isPlaying) {
            isPlaying = false;
            System.out.println("Paused...");
        } else {
            System.out.println("Already paused...");
        }
    }
    }

    public void skip() {
        synchronized (lock) {
            System.out.println("Skipped...");
        }
    }

    public void previous() {
        synchronized (lock) {
            System.out.println("Previous...");
        }
    }
}
