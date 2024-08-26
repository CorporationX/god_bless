package faang.school.godbless.BJS2_24381;

public class Player {
    private final Object lock = new Object();
    private boolean isPlaying = false;

    public void play() {
        synchronized (lock) {
            isPlaying = true;
            System.out.println("Music play");
        }
    }

    public void pause() {
        synchronized (lock) {
            isPlaying = false;
            System.out.println("Music pause");
        }
    }

    public void skip() {
        synchronized (lock) {
            if (isPlaying) {
                System.out.println("Music skip");
            } else {
                System.out.println("Can't skip, music is not playing");
            }
        }
    }

    public void previous() {
        synchronized (lock) {
            if (isPlaying) {
                System.out.println("Music previous track");
            } else {
                System.out.println("Can't previous track, music is not playing");
            }
        }
    }
}
