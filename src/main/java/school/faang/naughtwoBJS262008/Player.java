package school.faang.naughtwoBJS262008;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Player {
    private boolean isPlaying;
    private final Object lock = new Object();

    public void play() {
        synchronized(lock) {
            if(!isPlaying){
                isPlaying = true;
                System.out.println("Music is playing.");
            }
            else {
                System.out.println("Music is already playing.");
            }

        }
    }

    public void pause() {
        synchronized(lock) {
            if(isPlaying){
                isPlaying = false;
                System.out.println("Music is paused.");
            }
            else {
                System.out.println("Music is already paused.");
            }
        }
    }

    public void skip() {
        synchronized(lock) {
            System.out.println("Track skipped.");
        }
    }

    public void previous() {
        synchronized(lock) {
            System.out.println("Returned to the previous track.");
        }
    }
}
