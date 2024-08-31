package faang.school.godbless;

import java.util.concurrent.ThreadLocalRandom;

public class RandomGenerator {
    public double randomNum() {
        return ((int) (ThreadLocalRandom.current().nextDouble(1.01) * 10)) / 10.0;
    }
}
