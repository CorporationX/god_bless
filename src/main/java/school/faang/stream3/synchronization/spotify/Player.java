package school.faang.stream3.synchronization.spotify;

import lombok.Getter;

import java.util.List;

public class Player{
    private final Object userLock = new Object();
    private boolean isPlaying;
    private int positionPlaying;
    private final int playListSize;
    private RandomSongs playList;
    @Getter private List<User> userGroup;

    public Player(int playListSize) {
        this.playListSize = playListSize;
        playList = new RandomSongs(playListSize);
    }

    public void play() {
        synchronized (userLock) {
            isPlaying = true;
            System.out.println("this player has been stopped");
        }
    }

    public void pause() {
        synchronized (userLock) {
            isPlaying = false;
            System.out.println("the music is playing again now");
        }
    }

    public void skip(){
        synchronized (userLock){
            positionPlaying++;
        }
    }

    public void previous(){
        synchronized (userLock){
            positionPlaying--;
        }
    }

    public void showNextSongs(int amount){
        playList.showNextSongs(amount, positionPlaying);
    }

}
