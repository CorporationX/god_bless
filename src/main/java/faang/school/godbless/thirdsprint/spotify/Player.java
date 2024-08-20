package faang.school.godbless.thirdsprint.spotify;

import java.util.List;
import java.util.Random;

public class Player {
    private final Object lock = new Object();
    private boolean isPlaying;
    private boolean isStarted;
    private List<String> playlist;
    private int currentTrackIndex;

    public Player(List<String> playlist) {
        this.playlist = playlist;
        this.currentTrackIndex = new Random().nextInt(playlist.size());
        isPlaying = false;
        isStarted = false;
    }

    public void play() {
        synchronized (lock) {
            checkStartingCondition();

            if (!isPlaying) {
                isPlaying = true;
                System.out.println("Воспроизводится трек: " + playlist.get(currentTrackIndex));
            } else {
                System.out.println("Уже воспроизводится трек: " + playlist.get(currentTrackIndex));
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                isPlaying = false;
                System.out.println("Трек " + playlist.get(currentTrackIndex) + " поставлен на паузу");
            }
            if (!isStarted) {
                isStarted = true;
                System.out.println("Плеер включён. Текущий выбранный трек плейлиста "
                        + playlist.get(currentTrackIndex) + " поставлен на паузу");
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            checkStartingCondition();

            if (currentTrackIndex < playlist.size() - 1) {
                isPlaying = true;
                currentTrackIndex++;
                System.out.println("Переключение на следующий трек: " + playlist.get(currentTrackIndex));
            } else {
                currentTrackIndex = 0;
                System.out.println("Это последний трек в плейлисте. Переход на первый трек: " +
                        playlist.get(currentTrackIndex));
            }
        }
    }

    public void previous() {
        synchronized (lock) {
            checkStartingCondition();

            if (currentTrackIndex > 0) {
                isPlaying = true;
                currentTrackIndex--;
                System.out.println("Переключение на предыдущий трек: " + playlist.get(currentTrackIndex));
            } else {
                System.out.println(playlist.get(currentTrackIndex) +
                        " - первый трек в плейлисте. Переключение на предыдущий трек невозможно!");
            }
        }
    }

    private void checkStartingCondition() {
        if (!isStarted) {
            isStarted = true;
            System.out.println("Плеер включён. Текущий выбранный трек плейлиста: " + playlist.get(currentTrackIndex));
        }
    }
}
