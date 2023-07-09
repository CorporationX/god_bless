package faang.school.godbless.sprint_3.multithreading.spotify_blocked;

public class Player {
    private final Object lock = new Object();
    private boolean isPlaying = false;

    public void play() {
        synchronized (lock) {
            isPlaying = true;
            System.out.println("Музыка включена");
        }
    }

    public void pause() {
        synchronized (lock) {
            isPlaying = false;
            System.out.println("Музыка на паузе");
        }
    }

    public void skip() {
        synchronized (lock) {
            isPlaying = false;
            System.out.println("Включаю следующую музыку");
        }
    }

    public void previous() {
        synchronized (lock) {
            isPlaying = false;
            System.out.println("Предыдущая музыка");
        }
    }
}