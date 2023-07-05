package faang.school.godbless.spotify;

import java.util.List;

public class Player {
    private String isPlaying;
    final Object lock = new Object();
    private List<String> playList;

    public Player(String isPlaying, List<String> playList) {
        this.isPlaying = isPlaying;
        this.playList = playList;
    }

    public void play(){
        synchronized (lock){
            System.out.println("Play - " + isPlaying);
        }
    }
    public void pause(){
        synchronized (lock){
            System.out.println("Stop - " + isPlaying);
        }
    }
    public void skip(){
        synchronized (lock){
            int indexOfNext = playList.indexOf(isPlaying) == playList.size()-1 ? 0 : playList.indexOf(isPlaying)+1;
            isPlaying = playList.get(indexOfNext);
            System.out.println("Play next - " + isPlaying);
        }
    }
    public void previous(){
        synchronized (lock){
            int indexOfPrev = playList.indexOf(isPlaying) == 0 ? playList.size()-1 : playList.indexOf(isPlaying)-1;
            isPlaying = playList.get(indexOfPrev);
            System.out.println("Play previous - " + isPlaying);
        }
    }
}
