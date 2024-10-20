package school.faang.BJS2_34774;

import java.util.Random;

public enum NotificationType {
    SMS, EMAIL, PUSH;

    private static NotificationType[] values = values();
    private static int numberOfTypes = values.length;
    private static Random rand = new Random();

    public static NotificationType getRandomType() {
        return values[rand.nextInt(numberOfTypes)];
    }
}
