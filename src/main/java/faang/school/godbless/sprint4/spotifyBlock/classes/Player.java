package faang.school.godbless.sprint4.spotifyBlock.classes;

public class Player {
    private final Object LOCK = new Object();

    private boolean isPlaying;

    public void play() {
        synchronized (LOCK) {
            System.out.println("Playing...");
            isPlaying = true;
        }

    }

    public void pause() {
        synchronized (LOCK) {
            System.out.println("Pausing...");
            isPlaying = false;
        }

    }

    public void skip() {
        synchronized (LOCK) {
            System.out.println("Skipping...");

        }

    }

    public void pervious() {
        synchronized (LOCK) {
            System.out.println("Pervious...");

        }
    }
}
