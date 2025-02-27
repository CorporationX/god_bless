package school.faang.spotify.blocking;

public class Player {
    private final Object lock = new Object();
    private boolean isPlaying = false;

    public void play() {
        synchronized (lock) {
            if (!isPlaying) {
                isPlaying = true;
                System.out.println("Музыка воспроизводится.");
            } else {
                System.out.println("Музыка уже играет.");
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                isPlaying = false;
                System.out.println("Музыка поставлена на паузу.");
            } else {
                System.out.println("Музыка уже на паузе.");
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            System.out.println("Трек пропущен.");
        }
    }

    public void previous() {
        synchronized (lock) {
            System.out.println("Вернуть к предыдущему треку.");
        }
    }

    public static void main(String[] args) {
        Player player = new Player();

        Thread playThread = new Thread(player::play);
        playThread.start();

        Thread pauseThread = new Thread(player::pause);
        pauseThread.start();

        Thread skipThread = new Thread(player::skip);
        skipThread.start();

        Thread previousThread = new Thread(player::previous);
        previousThread.start();
    }
}