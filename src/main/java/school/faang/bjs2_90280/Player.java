package school.faang.bjs2_90280;

import lombok.Getter;

@Getter
public class Player {
    private final Object lock = new Object();
    private final int totalSongs = 10;
    private boolean isPlaying = false;
    private int currentSong = 1;

    public void play() {
        synchronized (lock) {
            if (!isPlaying) {
                isPlaying = true;
                System.out.printf("%s: Воспроизведение трека #%d%n",
                        Thread.currentThread().getName(), currentSong);
            } else {
                System.out.printf("%s: Песня уже играет%n",
                        Thread.currentThread().getName());
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                isPlaying = false;
                System.out.printf("%s: Песня приостановлена%n",
                        Thread.currentThread().getName());
            } else {
                System.out.printf("%s: Песня уже на паузе%n",
                        Thread.currentThread().getName());
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            if (currentSong < totalSongs) {
                currentSong++;
                System.out.printf("%s: Переключение на трек #%d%n",
                        Thread.currentThread().getName(), currentSong);
                if (isPlaying) {
                    System.out.printf("%s: Воспроизведение трека #%d%n",
                            Thread.currentThread().getName(), currentSong);
                }
            } else {
                System.out.printf("%s: Это последняя песня%n",
                        Thread.currentThread().getName());
            }
        }
    }

    public void previous() {
        synchronized (lock) {
            if (currentSong > 1) {
                currentSong--;
                System.out.printf("%s: Переключение на трек #%d%n",
                        Thread.currentThread().getName(), currentSong);
                if (isPlaying) {
                    System.out.printf("%s: Воспроизведение трека #%d%n",
                            Thread.currentThread().getName(), currentSong);
                }
            } else {
                System.out.printf("%s: Это первая песня%n",
                        Thread.currentThread().getName());
            }
        }
    }

    public void getStatus() {
        synchronized (lock) {
            String status = isPlaying ? "воспроизведение" : "пауза";
            System.out.printf("%s: Трек #%d, состояние: %s%n",
                    Thread.currentThread().getName(), currentSong, status);
        }
    }
}
