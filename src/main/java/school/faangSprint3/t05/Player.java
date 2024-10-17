package school.faangSprint3.t05;

public class Player {
    private final Object lock = new Object();
    private boolean isPlaying = false;

    public void play() {
        synchronized(lock) {
            isPlaying = true;
            System.out.println("Музыка начала воспроизводиться");
        }
    }

    public void pause() {
        synchronized(lock) {
            isPlaying = false;
            System.out.println("Музыка поставлена на паузу");
        }
    }

    public void skip() {
        synchronized(lock) {
            System.out.println("Трек пропущен");
        }
    }

    public void previous() {
        synchronized(lock) {
            System.out.println("Возврат к предыдущему треку");
        }
    }
}