package spotify.block;

public class Player {
    private final Object lock = new Object();
    private boolean isPlaying = true;

    public void play() {
        synchronized (lock) {
            if (!isPlaying) {
                isPlaying = true;
                System.out.println("Воспроизведение музыки");
            } else {
                System.out.println("Музыка уже играет");
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                isPlaying = false;
                System.out.println("Музыка приостановленна");
            } else {
                System.out.println("Музыка уже на паузе");
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            System.out.println("Следующий трек");
        }
    }

    public void previous() {
        synchronized (lock) {
            System.out.println("Предыдущий трек");
        }
    }
}
