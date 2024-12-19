package school.faang.bjs249531;

public class Player {

    private Object lock = new Object();
    private boolean isPlaying;

    public void play() {
        synchronized (lock) {
            try {
                Thread.sleep(2000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (!isPlaying) {
                isPlaying = true;
                System.out.println(Thread.currentThread().getName() + ". Music is playing.");
            } else {
                System.out.println(Thread.currentThread().getName() + ". Music is already playing.");
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            try {
                Thread.sleep(2000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (isPlaying) {
                isPlaying = false;
                System.out.println(Thread.currentThread().getName() + ". Music is stopped");
            } else {
                System.out.println(Thread.currentThread().getName() + ". Music is already paused");
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            try {
                Thread.sleep(2000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " is skipped");
        }
    }

    public void previous() {
        synchronized (lock) {
            try {
                Thread.sleep(2000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " changed to previous");
        }
    }

}
