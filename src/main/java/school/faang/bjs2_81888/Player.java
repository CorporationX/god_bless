package school.faang.bjs2_81888;

import java.util.List;

public class Player {
    private List<String> tracks;
    private int currentIndex;
    private boolean isPlaying;
    private final Object lock = new Object();

    public Player(List<String> tracks) {
        this.tracks = tracks;
        this.currentIndex = 0;
        this.isPlaying = false;
    }

    public void play() {
        synchronized (lock) {
            if (tracks == null || tracks.isEmpty()) {
                System.out.println("Нет треков для воспроизведения.");
                return;
            }
            if (isPlaying) {
                System.out.println("Трек уже воспроизводится.");
            } else {
                isPlaying = true;
                System.out.println("воспроищведение: " + tracks.get(currentIndex));
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                isPlaying = false;
                System.out.println("пауза " + tracks.get(currentIndex));
            } else {
                System.out.println("музыка уже на паузе ");
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            if (tracks == null || tracks.isEmpty()) {
                System.out.println("Нет треков для воспроизведения.");
                return;
            }
            if (currentIndex < tracks.size() - 1) {
                currentIndex++;
            } else {
                System.out.println("Это последний трек");
                return;
            }
            isPlaying = false;
            play();
        }
    }

    public void previous() {
        synchronized (lock) {
            if (tracks == null || tracks.isEmpty()) {
                System.out.println("нет треков для воспроизведения");
                return;
            }

            if (currentIndex > 0) {
                currentIndex--;
            } else {
                System.out.println("это первый трек");
            }
            isPlaying = false;
            play();
        }
    }

}

