package faang.school.godbless.spotify_blocking;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Player {
    private final Object lock = new Object();
    private boolean isPlaying;
    private String trackName;
    private final List<String> playList = List.of("track 1", "track 2", "track 3", "track 4", "track 5");
    private String currentTrack = playList.get(0); //устанавливаем первый трек из плей листа текущим треком

    public void play() throws InterruptedException {
        synchronized (lock) {
            if (!isPlaying) {
                isPlaying = true;
            }
            System.out.println("Music " + currentTrack + " plays");
        }
    }

    public void pause() throws InterruptedException {
        synchronized (lock) {
            if (isPlaying) {
                isPlaying = false;
            }
            System.out.println("Music " + currentTrack + " paused");
        }
    }

    public void skip() throws InterruptedException {
        synchronized (lock) {
            if (isPlaying) {
                isPlaying = false;
            }
            if (playList.indexOf(currentTrack) == playList.size() - 1) {
                currentTrack = playList.get(0);
            } else {
                currentTrack = playList.get(playList.indexOf(currentTrack) + 1);
            }
            isPlaying = true;
            System.out.println("Current music skipped. Next music is " + currentTrack);
        }
    }

    public void previous() throws InterruptedException {
        synchronized (lock) {
            if (isPlaying) {
                isPlaying = false;
            }
            if (playList.indexOf(currentTrack) == 0) {
                currentTrack = playList.get(playList.size() - 1);
            } else {
                currentTrack = playList.get(playList.indexOf(currentTrack) - 1);
            }
            isPlaying = true;
            System.out.println("Previous music plays. Current track name is: " + currentTrack);
        }
    }
}
