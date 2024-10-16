package school.faang.multithreading.synchron.spotify.blocking;

public class Player {
    private final Object lock = new Object();
    private boolean isPlaying;

    public void play() {
        synchronized (lock) {
            isPlaying = true;
            System.out.println("Музыка играет");
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
            System.out.println("Трек пропущен");
        }
    }

    public void previous() {
        synchronized (lock) {
            System.out.println("Предыдущий трек");
        }
    }
}
