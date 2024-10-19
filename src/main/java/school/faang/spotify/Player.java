package school.faang.spotify;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Player {
    private final Object lock = new Object();
    private volatile boolean isPlaying;

    public void play(){
        synchronized (lock){
            if (isPlaying) {
                System.out.println("Play song");
            }
        }
    }

    public void pause() {
        synchronized (lock){
            if (!isPlaying){
                System.out.println("Pause");
            }
        }
    }

    public void skip(){
        synchronized (lock){
            if (isPlaying){
                System.out.println("Skip the song");
            }
        }
    }

    public void previous(){
        synchronized (lock){
            if (isPlaying){
                System.out.println("Previous song");
            }
        }
    }
}
