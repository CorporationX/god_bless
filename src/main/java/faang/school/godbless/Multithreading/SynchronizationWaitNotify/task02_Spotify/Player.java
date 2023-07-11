package faang.school.godbless.Multithreading.SynchronizationWaitNotify.task02_Spotify;

public class Player {
    private final Object LOCK = new Object();
    private boolean isPlaying;

    public void play() {
        synchronized (LOCK) {
            System.out.println("Playing...");
            isPlaying = true;
        }
    }

    public void pause() {
        synchronized (LOCK) {
            System.out.println("Pausing...");
            isPlaying = false;
        }
    }

    public void skip() {
        synchronized (LOCK) {
            System.out.println("Skipping...");
        }
    }

    public void previous() {
        synchronized (LOCK) {
            System.out.println("Pervious...");
        }
    }
}
