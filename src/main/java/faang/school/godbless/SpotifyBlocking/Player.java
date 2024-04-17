package faang.school.godbless.SpotifyBlocking;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@RequiredArgsConstructor
public class Player {
    private final Object currentSongLock = new Object();
    private final Object isPlayingLock = new Object();
    private final List<String> playlist;
    private int currentSong = 0;
    private boolean isPlaying = true;

    public void play() {
        synchronized (isPlayingLock) {
            isPlaying = true;
            System.out.println("The music is playing");
        }
    }

    public void pause() {
        synchronized (isPlayingLock) {
            isPlaying = false;
            System.out.println("The music is paused");
        }
    }

    public void skip() {
        synchronized (currentSongLock) {
            if (playlist.isEmpty() || currentSong > playlist.size()) {
                System.out.println("Last song has no next songs");
            } else {
                currentSong++;
                System.out.println(playlist.get(currentSong) + " is playing now");
            }
        }
    }

    public void previous() {
        synchronized (currentSongLock) {
            if (playlist.isEmpty() || currentSong > playlist.size()) {
                System.out.println("First song has no previous songs");
            } else {
                currentSong--;
                System.out.println(playlist.get(currentSong) + " is playing now");
            }
        }
    }
}
