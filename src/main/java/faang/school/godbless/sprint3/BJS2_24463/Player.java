package faang.school.godbless.sprint3.BJS2_24463;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Player {
    private Object lock = new Object();
    private boolean isPlaying;

    public void play() {
        synchronized (lock) {
            if (!isPlaying) {
                isPlaying = true;
                System.out.println("Music playing");
            }
        }
    }
    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                isPlaying = false;
                System.out.println("Music paused");
            }
        }
    }
    public void skip() {
        synchronized (lock) {
            System.out.println("Song skipped");
            play();
        }
    }
    public void previous() {
        synchronized (lock) {
            System.out.println("Returned to previous song");
            play();
        }
    }
}
