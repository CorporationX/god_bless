package school.faang.task_44723.utils;

import java.util.Random;

public class IdGenerator {
    private static final Random random = new Random();

    public static int generateId() {
        return random.nextInt(0, Integer.MAX_VALUE);
    }
}
