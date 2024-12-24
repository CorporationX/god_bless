package school.faang.spring3.task_49329;

public class Player {

    private final Object lock = new Object();
    private boolean isPlaying;

    public void play() {
        synchronized (lock) {
            if (!isPlaying) {
                isPlaying = true;
                System.out.println("Music is playing");
            } else {
                System.out.println("Music already playing");
            }
        }
    }

    public void pause() {
        if (isPlaying) {
            isPlaying = false;
            System.out.println("Music is on pause");
        } else {
            System.out.println("Music already on pause");
        }

    }

    public void skip() {
        synchronized (lock) {
            System.out.println("Music skipped");
        }
    }

    public void previous() {
        synchronized (lock) {
            System.out.println("Previous music is playing");
        }
    }
}
