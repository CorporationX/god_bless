package school.faang.Multithreading.sprint_4.Spotify;

public class Player {
    private final Object lock = new Object();
    private boolean isPlaying;

    public void play() {
        synchronized (lock) {
            if (!isPlaying) {
                isPlaying = true;
                System.out.println("Музыка воспроизводится: isPlaying = " + isPlaying);
            } else {
                System.out.println("Музыка уже играет: isPlaying = " + isPlaying);
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                isPlaying = false;
                System.out.println("Музыка поставлена на паузу: isPlaying = " + isPlaying);
            } else {
                System.out.println("Музыка уже на паузе: isPlaying = " + isPlaying);
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
            System.out.println("Вернулись к предыдущему треку.");
        }
    }

}
