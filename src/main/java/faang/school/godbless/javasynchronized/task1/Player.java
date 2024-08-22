package faang.school.godbless.javasynchronized.task1;

public class Player {
    final Object lock = new Object();
    boolean isPlaying = false;

    public void play() {
        synchronized (lock) {
            isPlaying = true;
            System.out.println("Play");
        }
    }

    public void skip() {
        System.out.println("Skip");
    }
    public void pause() {
        synchronized (lock) {
            isPlaying = false;
            System.out.println("Pause");
        }
    }

    public void previous() {
        System.out.println("Previous");
    }
}
