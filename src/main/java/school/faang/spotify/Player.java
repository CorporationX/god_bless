package school.faang.spotify;

public class Player {
    private final Object lock = new Object();
    private boolean isPlaying = false;
    private int currentTrack = 1;

    public void play() {
        synchronized (lock) {
            if (!isPlaying) {
                isPlaying = true;
                System.out.printf("Воспроизведение трека #%d начато.%n", currentTrack);
            } else {
                System.out.println("Трек уже воспроизводится.");
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                isPlaying = false;
                System.out.printf("Трек #%d поставлен на паузу.%n", currentTrack);
            } else {
                System.out.println("Музыка уже на паузе.");
            }
        }
    }

    public void skip() {
        synchronized (lock)  {
            currentTrack++;
            isPlaying = true;
            System.out.printf("Переключено на следующий трек #%d и начато воспроизведение.%n", currentTrack);
        }
    }

    public void previous() {
        synchronized (lock) {
            if (currentTrack > 1) {
                currentTrack--;
            }
            isPlaying = true;
            System.out.printf("Вернулся к треку #%d и начато воспроизведение.%n", currentTrack);
        }
    }
}
