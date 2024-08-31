package faang.school.godbless.ThirdSprint.BJS2_26036;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;


public class Player {
    List<String> songList = Arrays.asList("ELM", "Goldie", "Caravan", "Hells bells");
    int currentSongIndex = ThreadLocalRandom.current().nextInt(1, 2);
    private String isPlaying = songList.get(currentSongIndex);

    public void play() {
        synchronized (isPlaying) {
            System.out.println(isPlaying + " is playing");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public synchronized void pause() {
        synchronized (isPlaying) {
            System.out.println(isPlaying + " is paused");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public synchronized void skip() {
        synchronized (isPlaying) {
            currentSongIndex += 1;
            isPlaying = songList.get(currentSongIndex);
            System.out.println(isPlaying + " is playing");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public synchronized void previous() {
        synchronized (isPlaying) {
            currentSongIndex -= 1;
            isPlaying = songList.get(currentSongIndex);
            System.out.println(isPlaying + " is playing");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
