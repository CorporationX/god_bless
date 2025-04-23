package school.faang.stream3.synchronization.spotify;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private final Object userLock = new Object();
    private boolean isPlaying;
    private int positionPlaying = 0;
    private final int playListSize;
    private RandomSongs playList;
    @Getter
    private List<User> userGroup = new ArrayList<>();

    public Player(int playListSize) {
        this.playListSize = playListSize;
        playList = new RandomSongs(playListSize);
        System.out.println("this player has been created. Start playing music.");
    }

    public void play() {
        synchronized (userLock) {
            isPlaying = true;
            System.out.println("the music is playing again now");
        }
    }

    public void pause() {
        synchronized (userLock) {
            isPlaying = false;
            System.out.println("this player has been stopped");
        }
    }

    public void skip() {
        synchronized (userLock) {
            positionPlaying++;
            if (positionPlaying == playList.playList.size()) {
                positionPlaying = 0;
            }
            System.out.println("music has been changed to "
                    + playList.playList.get(positionPlaying));
        }
    }

    public void previous() {
        synchronized (userLock) {
            positionPlaying--;
            if (positionPlaying < 0) {
                positionPlaying = playList.playList.size() - 1;
            }
            System.out.println("music has been changed to previous position - "
                    + playList.playList.get(positionPlaying));
        }
    }

    public void showNextSongs(int amount) {
        synchronized (userLock) {
            for (int i = positionPlaying; i < amount; i++) {
                if (i == positionPlaying) {
                    System.out.println(playList.playList.get(i) + " is playing now");
                } else {
                    System.out.println(playList.playList.get(i) + " is number " + i + " in line");
                }
            }
        }
    }
}
