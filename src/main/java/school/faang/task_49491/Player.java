package school.faang.task_49491;

public class Player {
    private final Object lock = new Object();
    boolean isPlaying;

    public void play() {
        synchronized (lock) {
            isPlaying = true;
            System.out.println("Play");
        }
    }

    public void pause() {
        synchronized (lock) {
            isPlaying = false;
            System.out.println("Pause");
        }
    }

    public void skip() {
        synchronized (lock) {
            System.out.println("Skip");
        }
    }

    public void previous() {
        synchronized (lock) {
            System.out.println("Previouss");
        }
    }
}
