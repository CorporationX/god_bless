package faang.school.godbless.location;

import java.util.Random;

public enum StatusVehicle {
    FREE, BUSY;

    private static final Random RANDOM = new Random();

    public static StatusVehicle randomStatusVehicle() {
        StatusVehicle[] statuses = values();
        return statuses[RANDOM.nextInt(statuses.length)];
    }
}
