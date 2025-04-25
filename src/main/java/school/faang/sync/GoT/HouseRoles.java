package school.faang.sync.GoT;

import java.util.Random;

public enum HouseRoles {
    LORD,
    KNIGHT,
    MAGE,
    PEASANT;

    private static final Random PRNG = new Random();

    public static HouseRoles getRandomHouseRole() {
        HouseRoles[] houseRoles = values();
        return houseRoles[PRNG.nextInt(houseRoles.length)];
    }
}
