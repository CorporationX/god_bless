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
            if (isPlaying) {
                System.out.println("the music is already playing now");
            } else {
                isPlaying = true;
                System.out.println("the music is playing again now");
            }
        }
    }

    public void pause() {
        synchronized (userLock) {
            if (!isPlaying) {
                System.out.println("the music was already paused");
            } else {
                isPlaying = false;
                System.out.println("this player has been stopped");
            }
        }
    }

    public void skip() {
        synchronized (userLock) {
            positionPlaying++;
            if (positionPlaying == playList.playList.size()) {
                positionPlaying = 0;
            }
            System.out.printf("music has been changed to %s\n",
                    playList.playList.get(positionPlaying));
        }
    }

    public void previous() {
        synchronized (userLock) {
            positionPlaying--;
            if (positionPlaying < 0) {
                positionPlaying = playList.playList.size() - 1;
            }
            System.out.printf("music has been changed to previous position - %s\n",
                    playList.playList.get(positionPlaying));
        }
    }

    public void showNextSongs(int amount) {
        synchronized (userLock) {
            for (int i = positionPlaying; i < amount; i++) {
                if (i == positionPlaying) {
                    System.out.printf("%s is playing now\n", playList.playList.get(i));
                } else {
                    System.out.printf("%s is number %d in line\n", playList.playList.get(i), i);
                }
            }
        }
    }
}
