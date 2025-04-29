package faang;

import lombok.Getter;

@Getter
public class Player {
    private boolean isPlaying;

    public synchronized void play() {
        if (isPlaying) {
            return;
        }

        this.isPlaying = true;
        System.out.println("I'm playing! " + isPlaying);
    }

    public synchronized void pause() {
        if (!isPlaying) {
            return;
        }

        this.isPlaying = false;
        System.out.println("I'm paused! " + isPlaying);
    }

    public synchronized void skip() {
        this.isPlaying = true;
        System.out.println("I'm skipped! " + isPlaying);
    }

    public synchronized void previous() {
        this.isPlaying = true;
        System.out.println("I'm previous! " + isPlaying);
    }
}
