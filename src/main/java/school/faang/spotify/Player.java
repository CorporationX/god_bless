package school.faang.spotify;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@RequiredArgsConstructor
@Getter
@Setter
public class Player {

    private boolean isPlaying;

    private final Object lock = new Object();

    public void play() {
        synchronized (lock) {
            if (!isPlaying) {
                isPlaying = true;
                System.out.println("Play");
            } else {
                System.out.println("Уже слушаете");
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                isPlaying = false;
                System.out.println("Pause");
            } else {
                System.out.println("Уже на паузе");
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            System.out.println("Skip");
        }
    }

    public void previous() {
        synchronized (lock) {
            System.out.println("Previous");
        }
    }


}
