package school.faang.m1s3.bjs2_37165_spotify;

import lombok.Getter;


public class Player {
    private final Object lock = new Object();
    private boolean isPlaying;
    @Getter
    private int actionsCount = 0;

    public void play() {
        synchronized (lock) {
            if (!isPlaying) {
                System.out.println("Play starts");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Play continues");
                isPlaying = true;
            } else {
                System.out.println("Nothing happens. Play is in progress");
            }
            actionsCount++;
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                System.out.println("Current song is paused");
                isPlaying = false;
            } else {
                System.out.println("Nothing happens. The play is paused already");
            }
            actionsCount++;
        }
    }

    public void skip() {
        synchronized (lock) {
            System.out.println("Next track");
            actionsCount++;
        }
    }

    public void previous() {
        synchronized (lock) {
            System.out.println("Previous track");
            actionsCount++;
        }
    }
}
