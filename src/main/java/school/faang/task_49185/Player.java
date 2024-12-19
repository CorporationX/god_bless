package school.faang.task_49185;

public class Player {
    private final Object lock = new Object();
    private boolean isPlaying;

    public void play() {
        System.out.println("Music is playing");
        changeStatus(true);
    }

    public void pause() {
        System.out.println("Music is stopped");
        changeStatus(false);
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
            System.out.println(String.format("Status of music: %s", isPlaying));
        }
    }
}
