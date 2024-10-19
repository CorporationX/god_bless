package school.faang.Spotify;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Player {
    private final Object lock = new Object();
    private volatile boolean isPlaying = false;

    public void play(){
        synchronized (lock){
            if(!isPlaying){
                isPlaying = true;
                System.out.println("Music is playing");
            } else {
                System.out.println("Music is already playing");
            }
        }
    }

    public void pause(){
        synchronized (lock){
            if(isPlaying){
                isPlaying = false;
                System.out.println("Music is paused");
            } else {
                System.out.println("Music is not playing");
            }
        }
    }

    public void skip(){
        synchronized (lock){
            System.out.println("Song skipped");
        }
    }

    public void previous(){
        synchronized (lock){
            System.out.println("Previous song");
        }
    }
}
