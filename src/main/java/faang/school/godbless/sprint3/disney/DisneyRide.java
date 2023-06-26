package faang.school.godbless.sprint3.disney;

import java.util.ArrayList;
import java.util.List;

public class DisneyRide {
    private final Object lock = new Object();
    private List<Wagon> wagons = new ArrayList<>();

    public void startRide() {
        Wagon wagon = new Wagon();
        Wagon wagon2 = new Wagon();

        wagons.add(wagon);
        wagons.add(wagon2);

        wagon.start();
        wagon2.start();
    }

    public void stopRide() {
        synchronized (lock) {
            for (Wagon wagon : wagons) {
                System.out.println("Wagon stopped");
                wagon.setMoving(false);
                lock.notifyAll();
            }

        }
    }

    public static void main(String[] args) throws InterruptedException {
        DisneyRide disneyRide = new DisneyRide();
        disneyRide.startRide();
        Thread.sleep(1000);
        disneyRide.stopRide();
    }

}
