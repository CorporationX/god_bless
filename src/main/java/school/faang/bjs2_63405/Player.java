package school.faang.bjs2_63405;

public class Player {

    private boolean isPlaying = false;
    private final Object lock = new Object();

    public void play() {
        if (!isPlaying) {
            synchronized (lock) {
                isPlaying = true;
                System.out.println("Music is playing");
            }
        }
    }

    public void pause() {
        if (isPlaying) {
            synchronized (lock) {
                isPlaying = false;
                System.out.println("Music is stopped");
            }
        }
    }

    public void skip() {
            System.out.println("Next song");
    }

    public void previous() {
            System.out.println("Previous song");
    }
}

