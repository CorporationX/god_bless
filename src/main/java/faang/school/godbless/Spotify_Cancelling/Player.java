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
    private final Object lock1 = new Object();
    private String isPlaying;
    private List<String> queue;
    private int currentSong;

    public Player(List<String> queue) {
        this.queue = queue;
    }

    public void play() {
        synchronized (lock1) {
            if (currentSong < queue.size()) {
                isPlaying = queue.get(currentSong);
                System.out.println(isPlaying + " is playing");
            } else {
                System.out.println("End of playlist");
            }
        }
    }

    public void pause() {
        synchronized (lock1) {
            if (isPlaying != null) {
                System.out.println(isPlaying + " is paused");
            } else {
                System.out.println("No song is playing");
            }
        }
    }

    public void skip() {
        synchronized (lock1) {
            if (currentSong < queue.size() - 1) {
                currentSong++;
                isPlaying = queue.get(currentSong);
                System.out.println(isPlaying + " is playing");
            } else {
                System.out.println("End of playlist");
            }
        }
    }

    public void queueAdd(String song) {
        synchronized (lock1) {
            queue.add(song);
        }
    }

    public void previous() {
        synchronized (lock1) {
            if (currentSong > 0) {
                currentSong--;
                isPlaying = queue.get(currentSong);
                System.out.println(isPlaying + " is playing");
            } else {
                System.out.println("Beginning of playlist");
            }
        }
    }
}
