package school.faang.task_49399;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Player {
    private boolean isPlaying;
    private final Lock lock;

    public void play() {
        System.out.println("Befor Play music, status isPlaying = " + isPlaying);
        synchronized (lock) {
            isPlaying = true;
            System.out.println("After Play music, status isPlaying = " + isPlaying);
        }
    }

    public void pause() {
        System.out.println("Befor Pause music, status isPlaying = " + isPlaying);
        synchronized (lock) {
            isPlaying = false;
            System.out.println("After Pause music, status isPlaying = " + isPlaying);
        }
    }

    public void skip() {
        System.out.println("Befor Skip music, status isPlaying = " + isPlaying);
        synchronized (lock) {
            System.out.println("After Skip music, status isPlaying = " + isPlaying);
        }
    }

    public void previous() {
        System.out.println("Befor Previous trek, status isPlaying = " + isPlaying);
        synchronized (lock) {
            System.out.println("After Previous trek, status isPlaying = " + isPlaying);
        }
    }
}
