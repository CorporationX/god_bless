package faang.school.godbless.multithreading.spotify;

import lombok.Getter;

import java.util.List;
import java.util.Random;

@Getter
public class Player {
    private Integer lock = new Random().nextInt(0, 4);
    private List<String> isPlaying;

    public Player() {
        this.isPlaying = List.of("Fifty cent", "Mocking bird", "Bouquet", "You are my enemy");
    }

    public void play() {
        synchronized (lock) {
            System.out.println("music play " + isPlaying.get(lock));
        }
    }

    public void pause() {
        synchronized (lock) {
            System.out.println("music pause " + isPlaying.get(lock));
        }
    }

    public void skip() {
        synchronized (lock) {
            if (lock == 3) {
                lock = 0;
            } else {
                lock += 1;
            }
            System.out.println("skip music play " + isPlaying.get(lock));
        }
    }

    public void previous() {
        synchronized (lock) {
            if (lock == 0) {
                lock = 3;
            } else {
                lock -= 1;
            }
            System.out.println("previous music play " + isPlaying.get(lock));
        }
    }
}
