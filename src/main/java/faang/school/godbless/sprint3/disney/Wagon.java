package faang.school.godbless.sprint3.disney;


public class Wagon extends Thread {
    private boolean moving = true;
    private final Object lock = new Object();


    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    @Override
    public void run() {
        synchronized (lock) {
            while (true) {
                if (moving) {
                    System.out.println("Wagon running");
                    lock.notifyAll();
                } else {
                    System.out.println("Wagon stopped");
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }

    public void stopWagon() {
        synchronized (lock) {
            System.out.println("Wagon stopped");
            moving = false;
            lock.notifyAll();
        }
    }

    public void resumeWagon() {
        synchronized (lock) {
            System.out.println("Wagon running");
            moving = true;
            lock.notifyAll();
        }
    }
}
