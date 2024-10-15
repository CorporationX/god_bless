package school.faang.spotifyblock;

import lombok.Getter;

@Getter
public class Player {

    private final Object lock = new Object();
    private String isPlaying;

    public void play(){
        synchronized (lock) {
            this.isPlaying = "Playing";
            System.out.println(Thread.currentThread().getName() + " " + isPlaying);
        }
    }

    public void pause(){
        synchronized (lock) {
            this.isPlaying = "Paused";
            System.out.println(Thread.currentThread().getName() + " " + isPlaying);
        }

    }

    public void skip(){
        synchronized (lock) {
            this.isPlaying = "Skipped track";
            System.out.println(Thread.currentThread().getName() + " " + isPlaying);
        }

    }

    public void previous(){
        synchronized (lock) {
            this.isPlaying = "Previous track";
            System.out.println(Thread.currentThread().getName() + " " + isPlaying);
        }

    }
}
