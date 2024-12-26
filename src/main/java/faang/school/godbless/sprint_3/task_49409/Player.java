package faang.school.godbless.sprint_3.task_49409;

public class Player {
    private int trackNumber = 1;
    private boolean isPlaying = true;

    private final Object lock = new Object();

    public void play() {
        synchronized (lock) {
            if (isPlaying) {
                System.out.println("Track №" + trackNumber + " is already playing");
                return;
            }
            isPlaying = true;
            System.out.println("Track №" + trackNumber + " on");
        }
    }

    public void pause() {
        synchronized (lock) {
            if (!isPlaying) {
                System.out.println("Track №" + trackNumber + " is already off");
                return;
            }
            isPlaying = false;
            System.out.println("Track №" + trackNumber + " off");
        }
    }

    public void skip() {
        synchronized (lock) {
            trackNumber++;
            System.out.println("Play next track №" + trackNumber);
        }
    }

    public void previous() {
        synchronized (lock) {
            if (trackNumber == 1) {
                System.out.println("Previous track does not exist");
                return;
            }
            trackNumber--;
            System.out.println("Play previous track №" + trackNumber);
        }
    }
}
