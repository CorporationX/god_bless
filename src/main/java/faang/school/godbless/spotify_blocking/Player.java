package faang.school.godbless.spotify_blocking;

import java.util.List;

public class Player {
    private boolean isPlaying;

    public void play() {
        System.out.println("Music plays");
    }

    public void pause() {
        System.out.println("Music paused");
    }

    public void skip() {
        System.out.println("Music skipped");
    }

    public void previous() {
        System.out.println("Previous music plays");
    }
}
