package faang.school.godbless.SpotifyBlocking;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@RequiredArgsConstructor
public class Player {
    private final Object lock = new Object();
    private final List<String> playlist;
    private int currentSong = 0;
    private boolean isPlaying = true;

    public void play() {
        synchronized (lock) {
            if (!isPlaying) {
                isPlaying = true;
                System.out.println("The music is playing");
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                isPlaying = false;
                System.out.println("The music is paused");
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            currentSong++;
            if (currentSong >= playlist.size()) {
                currentSong = 0;
            }
            System.out.println(playlist.get(currentSong) + " is playing now");
        }
    }

    public void previous() {
        synchronized (lock) {
            currentSong--;
            if (currentSong < 0) {
                currentSong = playlist.size() - 1;
            }
            System.out.println(playlist.get(currentSong) + " is playing now");
        }
    }
}
