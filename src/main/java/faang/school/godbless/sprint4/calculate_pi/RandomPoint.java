package faang.school.godbless.sprint4.calculate_pi;

import lombok.Getter;
import java.util.concurrent.ThreadLocalRandom;

@Getter
public class RandomPoint {
    private final double x;
    private final double y;

    public RandomPoint() {
        ThreadLocalRandom generator = ThreadLocalRandom.current();
        this.x = generator.nextDouble(1);
        this.y = generator.nextDouble(1);
    }

    public boolean isInside() {
        return Math.pow(this.x, 2) + Math.pow(this.y, 2) < 1;
    }
}
