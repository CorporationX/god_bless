package faang.school.godbless.Spotify_Cancelling;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class Player {
    private Object lock1 = new Object();
    private String isPlaying;
    private List<String> queue;

    public void play() {
        synchronized (lock1) {
            isPlaying = queue.get(0) + " is playing";
            System.out.println(isPlaying);
        }
    }

    public void pause() {
        synchronized (lock1) {
            isPlaying = isPlaying + " is paused";
            System.out.println(isPlaying);
        }
    }

    public void skip() {
        synchronized (lock1) {
            queue.removeFirst();
            isPlaying = queue.getFirst();
        }
    }

    public void queueAdd(String song) {
        synchronized (lock1) {
            queue.add(song);
        }
    }

    public void previous() {
        synchronized (lock1) {
        }

    }
}
