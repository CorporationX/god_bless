package faang.school.godbless.tracking_system;

import java.util.concurrent.ThreadLocalRandom;

public enum VehicleStatus {
    OCCUPIED,
    FREE;

    public static VehicleStatus getRandomStatus() {
        int randomIndex = ThreadLocalRandom.current().nextInt(0, VehicleStatus.values().length);
        return switch (randomIndex) {
            case 0 -> OCCUPIED;
            case 1 -> FREE;
            default -> throw new RuntimeException("Some Exception appeared during random in VehicleStatus");
        };
    }
}
