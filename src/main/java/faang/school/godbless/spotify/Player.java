package faang.school.godbless.spotify;

import lombok.Data;

@Data
public class Player {
    private final Object lock = new Object();
    private Song song;
    public boolean isPlaying;

    public void play() {
        synchronized (lock) {
            if (!isPlaying) {
                System.out.println(song.getName() + " by " + song.getArtist() + " is now playing...");
                isPlaying = true;
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                System.out.println(song.getName() + " is paused...");
                isPlaying = false;
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            song = song.getNext();
            System.out.println("Now playing " + song.getName() + "...");
        }
    }

    public void previous() {
        synchronized (lock) {
            song = song.getPrevious();
            System.out.println("Now playing " + song.getName() + "...");
        }
    }
}
