package faang.school.godbless.task;

import java.util.List;

public class Player {
    private final Object lock;
    private boolean isPlaying = false;
    private int currentSongIndex = 0;
    private final List<String> playlist;

    public Player(List<String> songs) {
        this.playlist = songs;
        this.lock = new Object();
    }

    public void play() {
        synchronized (lock) {
            isPlaying = true;
            System.out.println(playlist.get(currentSongIndex) + " is playing");
        }
    }

    public void pause() {
        synchronized (lock) {
            isPlaying = false;
            System.out.println(playlist.get(currentSongIndex) + " is paused");
        }
    }

    public void skip() {
        synchronized (lock) {
            if (currentSongIndex != playlist.size() - 1) {
                currentSongIndex++;
                if (isPlaying) {
                    System.out.println(playlist.get(currentSongIndex) + " is playing");
                } else {
                    System.out.println(playlist.get(currentSongIndex) + " in pause");
                }
            }
        }
    }

    public void previous() {
        synchronized (lock) {
            if (currentSongIndex != 0) {
                currentSongIndex--;
                if (isPlaying) {
                    System.out.println(playlist.get(currentSongIndex) + " is playing");
                } else {
                    System.out.println(playlist.get(currentSongIndex) + " in pause");
                }
            }
        }
    }
}
