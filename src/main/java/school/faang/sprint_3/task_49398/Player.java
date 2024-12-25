package school.faang.sprint_3.task_49398;

public class Player {
    private final Object lock = new Object();
    private boolean isPlaying = true;

    public void play() {
        synchronized (lock) {
            if (!isPlaying) {
                isPlaying = true;
                System.out.println("Music playing");
            } else {
                System.out.println("Music not playing");
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (!isPlaying) {
                isPlaying = false;
                System.out.println();
                System.out.println("Music on pause");
            } else {
                System.out.println("Music already on pause");
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            System.out.println("Track skipped");
        }
    }

    public void previous() {
        synchronized (lock) {
            System.out.println("Return previous treck");
        }
    }
}
