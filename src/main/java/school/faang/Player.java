package school.faang;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Player {
    private  Object lock = new Object();
    private  boolean isPlayer;

    public void play() {
        synchronized (lock) {
            if (!isPlayer) {
                isPlayer = true;
                System.out.println("Play music");
            } else {
                System.out.println("music playing");
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlayer) {
                isPlayer = false;
                System.out.println("Pause music");
            } else {
                System.out.println("music paused");
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            System.out.println("skip");
        }
    }

    public void previous() {
        synchronized (lock) {
            System.out.println("previous");
        }
    }

}
