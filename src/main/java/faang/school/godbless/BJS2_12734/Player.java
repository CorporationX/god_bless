package faang.school.godbless.BJS2_12734;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Getter
public class Player {
    private final Object lock = new Object();
    private boolean isPlaying;
    private String recentSong;
    private List<String> music = Arrays.asList("Linking Park - Numb", "3 Days Grace - I hate everything about you", "Stone Sour - Made of Scars", "Papa Roach - Scars", "In this moment - adrenalize");

    public void play() {
        synchronized (lock) {
            System.out.println("Play method hase started");
            this.isPlaying = true;
            if (this.recentSong == null || this.recentSong.isEmpty()) {
                int pos = new Random().nextInt(music.size());
                recentSong = music.get(pos);
                System.out.println(recentSong + " is playing now");
            } else {
                System.out.println(recentSong + " proceed playing");
            }
        }
    }

    public void pause() {

        synchronized (lock) {
            this.isPlaying = false;
            System.out.println("Pause method hase started");
            if (this.recentSong == null || this.recentSong.isEmpty()) {
                System.out.println("push Play for the first");
            }
            System.out.println(this.recentSong + " has been paused");
        }
    }

    public void skip() {
        synchronized (lock) {
            int pos;
            System.out.println("Skip method hase started");
            if (!recentSong.isEmpty()) {
                pos = music.indexOf(recentSong);
                pos++;
                if (pos == music.size()) {
                    pos = 0;
                }
                recentSong = music.get(pos);
                System.out.println(recentSong + " is playing now");
            } else {
                System.out.println("push Play for the first");
            }
        }
    }

    public void previous() {

        synchronized (lock) {
            System.out.println("Previous method hase started");
            int pos;
            if (!recentSong.isEmpty()) {
                pos = music.indexOf(recentSong);
                pos--;
                if (pos < 0) {
                    pos = music.size();
                }
                recentSong = music.get(pos);
                System.out.println(recentSong + " is playing now");
            } else {
                System.out.println("push Play for the first");
            }
        }
    }


}
