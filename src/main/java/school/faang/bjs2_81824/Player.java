package school.faang.bjs2_81824;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Player {
    private final Object lock = new Object();
    private  boolean isPlaying = false;

    public void play() {
        synchronized (lock) {
            isPlaying = true;
            System.out.println("music is playing");
        }
    }

    public void pause() {
        synchronized (lock) {
            isPlaying = false;
            System.out.println("pause");
        }
    }

    public void skip() {
        synchronized (lock) {
            System.out.println("next trek");
        }
    }

    public void previous() {
        synchronized (lock) {
            System.out.println("previous trek");
        }
    }
}