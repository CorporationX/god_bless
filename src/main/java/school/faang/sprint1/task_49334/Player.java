package school.faang.sprint1.task_49334;

public class Player {
    private final Object lock = new Object();
    private boolean isPlaying;

    public void play() {
        synchronized (lock) {
            if (!isPlaying) {
                System.out.println("Play music");
                isPlaying = true;
            } else {
                System.out.println("The music is already playing");
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                System.out.println("Pause music");
                isPlaying = false;
            } else {
                System.out.println("The music is already on pause");
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            System.out.println("Music skip");
        }
    }

    public void previous() {
        synchronized (lock) {
            System.out.println("Music previous");
        }
    }
}
