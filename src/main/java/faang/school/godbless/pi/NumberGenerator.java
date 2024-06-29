package faang.school.godbless.pi;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class NumberGenerator {
    public Double generate(){
        return ThreadLocalRandom.current().nextDouble();
    }
}
