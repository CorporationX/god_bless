package faang.school.godbless.spotify;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Player {
    private final Lock lock;
    private boolean isPlaying;
    private Song currentSong;

    public Player(){
        lock = new ReentrantLock();
    }

    public void play(Song song){
        synchronized (lock){
            isPlaying = true;
            currentSong = song;
            System.out.println(song.getTitle() + " by " + song.getMusician());
        }
        try {
            Thread.sleep( (long) song.getDuration() * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void pause(){
        synchronized (lock){
            if (isPlaying){
                isPlaying = false;
                System.out.println(currentSong.getTitle() + " is paused");
            }
        }
    }

    public void skip(Song nextSong){
        synchronized (lock){
           if(currentSong != null){
               System.out.println("Skipping " + currentSong.getTitle());
               play(nextSong);
           }
        }
    }

    public void previous(Song previousSong){
        synchronized (lock){
            if (currentSong != null){
                System.out.println("Going back to previous song from " + currentSong.getTitle());
                play(previousSong);
            }
        }
    }
}