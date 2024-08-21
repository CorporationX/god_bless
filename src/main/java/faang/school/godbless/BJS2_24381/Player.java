package faang.school.godbless.BJS2_24381;

public class Player {
    private Object lock = new Object();
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
            isPlaying = false;
            System.out.println("Music skip");
        }
    }

    public void previous() {
        synchronized (lock) {
            isPlaying = false;
            System.out.println("Music previous");
        }
    }
}
