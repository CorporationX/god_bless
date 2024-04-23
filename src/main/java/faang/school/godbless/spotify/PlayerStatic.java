package faang.school.godbless.spotify;

public class PlayerStatic {
    private static boolean isPlaying = false;

    public synchronized void play() {
        if (!isPlaying) {
            isPlaying = true;
            System.out.println("Static player is Playing");
        } else {
            System.out.println("Music is already playing in static player");
        }
    }

    public synchronized void pause() {
        if (isPlaying) {
            isPlaying = false;
            System.out.println("Static player is Paused");
        } else {
            System.out.println("Music is already paused in static player");
        }
    }

    public synchronized void skip() {
        System.out.println("Skipping song in static player");
        isPlaying = false;
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        play();
    }

    public synchronized void previous() {
        System.out.println("Going to previous song in static player");
        isPlaying = false;
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        play();
    }

}
