package school.faang.task_49185;

public class Player {
    private final Object lock = new Object();
    private boolean isPlaying;

    public void play() {
        if (isPlaying) {
            System.out.println("Music is already playing");
        } else {
            changeStatus(true);
        }
    }

    public void pause() {
        if (isPlaying) {
            changeStatus(false);
        } else {
            System.out.println("Music is already stopped");
        }
    }

    public void skip() {
        synchronized (lock) {
            System.out.println("Song skipped");
        }
    }

    public void previous() {
        synchronized (lock) {
            System.out.println("Return to previous track");
        }
    }

    private void changeStatus(boolean status) {
        synchronized (lock) {
            isPlaying = status;
            System.out.println(String.format("Music is: %s", isPlaying ? "playing" : "stopped"));
        }
    }
}
