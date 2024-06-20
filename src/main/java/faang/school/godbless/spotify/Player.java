package faang.school.godbless.spotify;

public class Player {
    private Object lock = new Object();

    private boolean isPlaying;

    public void play() {
        synchronized (lock) {
            if (!isPlaying) {
                isPlaying = true;
            }
            System.out.println("Music playing");
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                isPlaying = false;
            }
            System.out.println("Music on pause");
        }
    }

    public void skip() {
        synchronized (lock) {
            isPlaying = true;
            System.out.println("Music skipped");
        }
    }

    public void previous() {
        synchronized (lock) {
            isPlaying = true;
            System.out.println("Music switched to the previous");
        }
    }

}
