package faang.school.godbless.musicPlayer;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Getter
public class Player {

    private final List<String> PLAY_LIST =
            new ArrayList<>(List.of("Track1", "Track2", "Track3", "Track4", "Track5", "Track6", "Track7"));
    private Object lock = new Object();
    private boolean isPlaying;
    private String nowPlaying;

    public void play() {
        synchronized (lock) {
            System.out.println("Method play");
            if (nowPlaying == null) {
                nowPlaying = PLAY_LIST.get(new Random().nextInt(PLAY_LIST.size()));
            }
            isPlaying = true;
            printTrackInfo();
        }
    }

    public void pause() {
        synchronized (lock) {
            System.out.println("Method pause");
            isPlaying = false;
            printTrackInfo();
        }
    }

    public void skip() {
        synchronized (lock) {
            System.out.println("Method skip");
            int nextTrackIndex = PLAY_LIST.indexOf(nowPlaying) + 1;
            nowPlaying = PLAY_LIST.get(nextTrackIndex >= PLAY_LIST.size() ? 0 : nextTrackIndex);
            printTrackInfo();
        }
    }

    public void previous() {
        synchronized (lock) {
            System.out.println("Method previous");
            int prevTrackIndex = PLAY_LIST.indexOf(nowPlaying) - 1;
            nowPlaying = PLAY_LIST.get(prevTrackIndex < 0 ? PLAY_LIST.size() - 1 : prevTrackIndex);
            printTrackInfo();
        }
    }

    private void printTrackInfo() {
        System.out.println(nowPlaying);
    }
}
