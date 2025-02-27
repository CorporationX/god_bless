package school.faang.task_BJS2_61951;

public class Player {
    private final Object lock = new Object();
    private Boolean isPlaying = false;

    public void play() {
        synchronized (lock) {
            while (isPlaying) { //ждем пока музыка не будет на паузе
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    System.out.println("Thread is interrupted");
                }
            }
            System.out.println("The music has just started playing");
            isPlaying = true;
            lock.notifyAll();
        }
    }

    public void pause() {
        synchronized (lock) {
            while (!isPlaying) {
                try {
                    lock.wait(); //ждем пока музыка не начнет играть
                } catch (InterruptedException e) {
                    System.out.println("Thread is interrupted");
                }
            }
            System.out.println("The music has just paused");
            isPlaying = false;
            lock.notifyAll();
        }
    }

    public void skip() {
        synchronized (lock) {
            System.out.println("The track has been skipped");
        }
    }

    public void previous() {
        synchronized (lock) {
            System.out.println("You've just switched to previous track");
        }
    }
}