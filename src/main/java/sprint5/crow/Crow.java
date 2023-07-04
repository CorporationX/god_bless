package sprint5.crow;

import lombok.Data;

import java.util.Random;

@Data
public class Crow {
    private static final Random RANDOM = new Random();
    private final String whereIsFlying;
    private final String message;

    public boolean willFlightBeGood() {
        flightSimulation();
        return RANDOM.nextBoolean();
    }

    private void flightSimulation() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            System.out.println("Work interrupted");
        }
    }
}
