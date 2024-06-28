package faang.school.godbless.BJS2_12734;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Getter
public class Player {
    private boolean isPlaying;
    private String recentSong;
    private List<String> music = Arrays.asList("Linking Park - Numb", "3 Days Grace - I hate everything about you", "Stone Sour - Made of Scars", "Papa Roach - Scars", "In this moment - adrenalize");
    int pos;

    public synchronized void play() {
        pos = new Random().nextInt(music.size());
        System.out.println("Play method has started");
        this.isPlaying = true;
        if (this.recentSong == null) {
            recentSong = music.get(pos);
            System.out.println(recentSong + " is playing now");
        } else {
            System.out.println(recentSong + " proceed playing");
        }
    }

    public synchronized void pause() {
        this.isPlaying = false;
        System.out.println("Pause method hase started");
        if (this.recentSong == null) {
            System.out.println("push Play for the first");
        }
        System.out.println(this.recentSong + " has been paused");
    }

    public synchronized void skip() {
        System.out.println("Skip method hase started");
        pos = music.indexOf(recentSong) + 1;
        if (pos == music.size()) {
            pos = 0;
        }
        recentSong = music.get(pos);
        System.out.println(recentSong + " is playing now");
    }

    public synchronized void previous() {
        System.out.println("Previous method hase started");
        pos = music.indexOf(recentSong)-1;
        if (pos < 0) {
            pos = music.size();
        }
        recentSong = music.get(pos);
        System.out.println(recentSong + " is playing now");
    }
}
