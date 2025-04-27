package school.faang.bjs2_63405;

public class Player {

    private String isPlaying = "Not playing";

    public void play() {
        synchronized (isPlaying) {
            isPlaying = "Playing";
            System.out.println("Music is playing");
        }
    }

    public void pause() {
        synchronized (isPlaying) {
            isPlaying = "On pause";
            System.out.println("Music is stopped");
        }
    }

    public void skip() {
        synchronized (isPlaying) {
            isPlaying = "Playing";
            System.out.println("Next song");
        }
    }

    public void previous() {
        synchronized (isPlaying) {
            isPlaying = "Playing";
            System.out.println("Previous song");
        }
    }
}

