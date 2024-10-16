package school.faang.spotify;

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
            System.out.println("Музыка не играет");
        }
    }

    public void skip() {
        synchronized (lock) {
            System.out.println("Трек пропущен");
        }
    }

    public void previous() {
        synchronized (lock) {
            System.out.println("Включен предыдущий трек");
        }
    }
}
