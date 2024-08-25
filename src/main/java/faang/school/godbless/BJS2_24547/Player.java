package faang.school.godbless.BJS2_24547;

public class Player {
    private final Lock lock = new Lock();
    private boolean isPlaying = false;
    public void play() {
        synchronized (lock) {
            isPlaying = (isPlaying) ? false : true; // if song is already playing it will be paused
            System.out.println(isPlaying ? "Song is played" : "Song is paused");
        }
    }

    public void pause() {
        synchronized (lock) {
            isPlaying = (!isPlaying) ? true : false; // if song is already paused it will be played
            System.out.println(isPlaying ? "Song is played" : "Song is paused");
        }
    }

    public void skip() {
        synchronized (lock) {
            System.out.println("Next song");
            isPlaying = true;
        }
    }

    public void previous() {
        synchronized (lock) {
            System.out.println("Previous song");
            isPlaying = true;
        }
    }
}
