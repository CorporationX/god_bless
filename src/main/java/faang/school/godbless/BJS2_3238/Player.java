package faang.school.godbless.BJS2_3238;

public class Player {
    private final Object lock = new Object();
    private boolean isPlaying;

    public void play() {
        synchronized (lock) {
            System.out.println("Play method:");
            if (!isPlaying) {
                isPlaying = true;
                System.out.println("Track is playing");
            } else {
                System.out.println("Track is already playing");
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            System.out.println("Pause method:");
            if (isPlaying) {
                isPlaying = false;
                System.out.println("Track is paused");
            } else {
                System.out.println("Track is already paused");
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            System.out.println("Skip method:");
            if (isPlaying) {
                System.out.println("Track was skipped");
            } else {
                System.out.println("Nothing to skip!");
            }
        }
    }

    public void previous() {
        synchronized (lock) {
            System.out.println("Previous method:");
            if (!isPlaying) {
                isPlaying = true;
            }
            System.out.println("Previous track is playing");
        }

    }

}
