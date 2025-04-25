package school.faang.blocking_spotify;

public class Player {
    volatile boolean isPlaying;
    private int currentTrackIndex;
    private final String[] playlist;

    private final Object lock = new Object();

    public Player() {
        this.isPlaying = false;
        this.currentTrackIndex = 0;
        this.playlist = new String[]{"Track 1", "Track 2", "Track 3"};
    }

    public void play() {
        synchronized (lock) {
            if (!isPlaying) {
                isPlaying = true;
                System.out.println("Воспроизведение: " + playlist[currentTrackIndex]);
            } else {
                System.out.println("Музыка уже воспроизводится");
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                isPlaying = false;
                System.out.println("Пауза");
            } else {
                System.out.println("Музыка уже на паузе");
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            currentTrackIndex = (currentTrackIndex + 1) % playlist.length;
            if (isPlaying) {
                System.out.println("Переключено на следующий трек: " + playlist[currentTrackIndex]);
            } else {
                System.out.println("Готов к воспроизведению: " + playlist[currentTrackIndex]);
            }
        }
    }

    public void previous() {
        synchronized (lock) {
            currentTrackIndex = (currentTrackIndex - 1 + playlist.length) % playlist.length;
            if (isPlaying) {
                System.out.println("Переключено на предыдущий трек: " + playlist[currentTrackIndex]);
            } else {
                System.out.println("Готов к воспроизведению: " + playlist[currentTrackIndex]);
            }
        }
    }

    public void isPlaying() {
        synchronized (lock) {
            System.out.println("Текущий трек: " + playlist[currentTrackIndex] +
                    ", Состояние: " + (isPlaying ? "играет" : "на паузе"));
        }
    }
}
