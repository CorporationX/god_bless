package school.faang.sprint3.spotify;

public class Player {
    private final Object lock = new Object();
    private String isPlaying = "";


    public void play() {
        synchronized (lock) {
            if (isPlaying.equals("Music is playing")) {
                System.out.println("Music already playing");
            } else {
                isPlaying = "Music is playing";
                System.out.println("Play");
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying.equals("Music is paused")) {
                System.out.println("Music already paused");
            } else {
                isPlaying = "Music is paused";
                System.out.println("Pause");
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            isPlaying = "Pressed skip";
            System.out.println("Skip");
        }
    }

    public void previous() {
        synchronized (lock) {
            isPlaying = "Pressed previous";
            System.out.println("Previous");
        }
    }
}
