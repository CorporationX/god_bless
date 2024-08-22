package faang.school.godbless.BJS2_24449;

import lombok.Getter;

import java.util.List;

@Getter
public class Player {
    private final Object LOCK = new Object();
    private final List<String> songs;
    private boolean isPlaying;
    private int index;

    public Player(List<String> songs) {
        this.songs = songs;
    }

    public void play() {
        if (!isPlaying) {
            synchronized (LOCK) {
                System.out.println("Play: Now is playing " + songs.get(index));
                isPlaying = true;
            }
        }
    }

    public void pause() {
        if (isPlaying) {
            synchronized (LOCK) {
                System.out.println("Pause: Track: " + songs.get(index) + " is paused");
                isPlaying = false;
            }
        }
    }

    public void skip() {
        if (isPlaying) {
            synchronized (LOCK) {
                System.out.print("Skip: Track: " + songs.get(index) + " is skipped. ");
                index = (index + 1) % songs.size();
                System.out.println("Next track is " + songs.get(index));
                isPlaying = true;
            }
        }
    }

    public void previous() {
        if (isPlaying) {
            synchronized (LOCK) {
                isPlaying = false;
                index = (index - 1 + songs.size()) % songs.size();
                System.out.println("Previous: Now is playing previous track" + songs.get(index));
                isPlaying = true;
            }
        }
    }
}
