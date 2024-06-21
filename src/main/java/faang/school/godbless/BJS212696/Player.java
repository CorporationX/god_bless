package faang.school.godbless.BJS212696;

public class Player {
    private boolean isPlaying;
    private final Object lock = new Object();

    public void play() {
        synchronized (lock) {
            isPlaying = true;
            System.out.println("Music is playing");
        }
    }

    public void pause() {
        synchronized (lock) {
            isPlaying = false;
            System.out.println("Music on pause");
        }
    }

    public void skip() {
        synchronized (lock) {
            System.out.println("Skipping this song");
        }
    }

    public void previous() {
        synchronized (lock) {
            System.out.println("Let's listen the previous song");
        }
    }

}
