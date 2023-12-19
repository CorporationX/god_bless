package faang.school.godbless.multi.task5disney;

public class Wagon extends Thread {
    private final DisneyRide disneyRide;
    private boolean moving = true;

    public Wagon(DisneyRide disneyRide) {
        this.disneyRide = disneyRide;
    }

    @Override
    public void run() {
        try {
            while (true) {
                synchronized (this) {
                    while (!moving) {
                        System.out.println(Thread.currentThread().getName() + " ожидает.");
                        wait();
                    }
                    System.out.println(Thread.currentThread().getName() + " движется.");
                }
                synchronized (disneyRide) {
                    if (!disneyRide.isRideRunning()) {
                        stopWagon();
                    }
                }
            }
        } catch (InterruptedException e) {
            System.out.println("Атракцион сломан!");
        }
    }

    public synchronized void stopWagon() {
        moving = false;
        notifyAll();
    }

    public synchronized void resumeWagon() {
        moving = true;
        notifyAll();
    }

}
