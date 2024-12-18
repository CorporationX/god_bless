package school.faang.task_48239;

public class Player {
    private static final Object lock = new Object();
    private boolean isPlaying = false;

    public void play() {
        synchronized (lock) {
            if (isPlaying) {
                System.out.println("Song is already playing!");
                return;
            }
            isPlaying = true;
            System.out.println("Song is starting!");
        }
    }

    public void pause() {
        synchronized (lock) {
            if (!isPlaying) {
                System.out.println("Song is already paused!");
                return;
            }
            isPlaying = false;
            System.out.println("Song is paused!");
        }
    }

    public void skip() {
        synchronized (lock) {
            if (!isPlaying) {
                System.out.println("You need to start playing to skip a song!");
                return;
            }
            System.out.println("The song was skipped! Lets start a new one!");
        }
    }

    public void previous() {
        synchronized (lock) {
            if (!isPlaying) {
                System.out.println("You need to start playing to return a song!");
                return;
            }
            System.out.println("The song was returned! Lets listen another time!");
        }
    }
}
