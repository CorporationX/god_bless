package faang.school.godbless.BJS212723;

public class Player {

    private Object playerControl = new Object();
    private boolean isPlaying;

    public void play() {
        synchronized (playerControl) {
            isPlaying = true;
            System.out.println(String.format("Thread %s is playing", Thread.currentThread().getName()));
        }
    }

    public void pause() {
        synchronized (playerControl) {
            isPlaying = false;
            System.out.println(String.format("Thread %s is pausing", Thread.currentThread().getName()));
        }
    }

    public void skip() {
        synchronized (playerControl) {
            System.out.println(String.format("Thread %s is skipping player", Thread.currentThread().getName()));
        }
    }

    public void previous() {
        synchronized (playerControl) {
            System.out.println(String.format("Thread %s is previous player", Thread.currentThread().getName()));
        }
    }
}
