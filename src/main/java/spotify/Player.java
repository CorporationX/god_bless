package spotify;

public class Player {
    private final Object lock = new Object();
    boolean isPlaying;

    public void play() {
        synchronized (lock) {
            if (isPlaying) {
                System.out.println("The music is already playing");
            } else {
                System.out.println("Music is playing");
                isPlaying = true;
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                System.out.println("Music stopped");
                isPlaying = false;
            } else {
                System.out.println("The music isn't playing now");
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            System.out.println("The next song is playing");
            isPlaying = true;
        }
    }

    public void previous() {
        synchronized (lock) {
            System.out.println("The previous song is playing");
            isPlaying = true;
        }
    }
}
