package faang.school.godbless.BJS2_26017;

public class Player {

    private final Object lock = new Object();
    private boolean isPlaying = false;

    public void play(){
        synchronized (lock){
            if (!isPlaying) {
                isPlaying = true;
                System.out.println("Music is now playing.");
            } else {
                System.out.println("Music is already playing.");
            }
        }
    }

    public void pause(){
        synchronized (lock){
            if (isPlaying) {
                isPlaying = false;
                System.out.println("Music has been paused.");
            } else {
                System.out.println("Music is already paused.");
            }
        }
    }

    public void skip(){
        synchronized (lock) {
            if (isPlaying) {
                System.out.println("Skipped to the next track.");
            } else {
                System.out.println("Cannot skip, music is paused.");
            }
        }
    }

    public void previous(){
        synchronized (lock){
            if (isPlaying) {
                System.out.println("Returned to the previous track.");
            } else {
                System.out.println("Cannot go back, music is paused.");
            }
        }
    }
}
