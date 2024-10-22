package school.faang.multithreading.spotify;

import java.util.Arrays;
import java.util.List;

public class Player {
    private boolean isPlaying = false;
    private final List<String> playList = Arrays.asList("Show must go on", "Колизей", "Still loving you");

    public void play() {
        synchronized(playList) {
            isPlaying = true;
            System.out.println("play");
        }
    }

    public void pause() {
        synchronized(playList) {
            isPlaying = false;
            System.out.println("pause");

        }
    }

    public void skip() {
        synchronized(playList) {
            isPlaying = true;
            System.out.println("skip");
        }
    }

    public void previous() {
        synchronized(playList) {
            isPlaying = true;
            System.out.println("previous");
        }
    }
}
