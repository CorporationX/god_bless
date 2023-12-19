package faang.school.godbless.multi.task5disney;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class DisneyRide {
    private final List<Wagon> wagons = new ArrayList<>();
    private boolean rideRunning = true;

    public synchronized void startRide(int numberOfWagons) {
        for (int i = 0; i < numberOfWagons; i++) {
            Wagon wagon = new Wagon(this);
            wagons.add(wagon);
            wagon.start();
        }
    }

    public synchronized void stopRide() {
        rideRunning = false;
        notifyAll();
    }
}

