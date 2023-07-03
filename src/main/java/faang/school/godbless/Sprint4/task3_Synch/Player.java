package faang.school.godbless.Sprint4.task3_Synch;

public class Player {
    private final Object lock = new Object();
    private boolean isPlaying = false;

    public void play() {
        synchronized (lock) {
            if (!isPlaying) {
                System.out.println("Music on");
                isPlaying = true;
            } else {
                System.out.println("Music is already playing");
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                System.out.println("Music off");
                isPlaying = false;
            } else {
                System.out.println("Music is not playing");
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            if (isPlaying) {
                System.out.println("Next track");
            } else {
                System.out.println("Music is not playing");
            }
        }
    }

    public void previous() {
        synchronized (lock) {
            if (isPlaying) {
                System.out.println("Previous track");
            } else {
                System.out.println("Music is not playing");
            }
        }
    }
}
