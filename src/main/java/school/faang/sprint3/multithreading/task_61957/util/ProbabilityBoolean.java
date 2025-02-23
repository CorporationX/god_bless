package school.faang.sprint3.multithreading.task_61957.util;

import java.util.Random;

public class ProbabilityBoolean {
    private static final Double PROBABILITY_LIFE_LOST = 0.2;
    private static final Double PROBABILITY_POINT_EARN = 0.45;
    private static final Random RANDOM = new Random();

    public static boolean getRandomLifeLost() {
        return RANDOM.nextDouble() < PROBABILITY_LIFE_LOST; // 20% - true, 8 0% - false
    }

    public static boolean getRandomPointEarn() {
        return RANDOM.nextDouble() < PROBABILITY_POINT_EARN;
    }
}
