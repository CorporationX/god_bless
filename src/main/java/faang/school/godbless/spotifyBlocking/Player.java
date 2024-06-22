package faang.school.godbless.spotifyBlocking;

public class Player {

    private String lock = "lock";
    private boolean isPlayer = false;

    public void play() {
        synchronized (lock) {
            isPlayer = true;
            System.out.println("Music is playing " + isPlayer);
        }
    }

    public void pause() {
        synchronized (lock) {
            isPlayer = false;
            System.out.println("Music is paused " + isPlayer);
        }
    }

    public void skip() {
        synchronized (lock) {
            System.out.println("Music is skipped " + isPlayer);
        }
    }

    public void stop() {
        synchronized (lock) {
            isPlayer = false;
            System.out.println("Music is stopped " + isPlayer);
        }
    }
}