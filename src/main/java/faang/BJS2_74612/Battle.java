package faang.BJS2_74612;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadLocalRandom;

public final class Battle {
    private final ThreadLocalRandom random = ThreadLocalRandom.current();

    public Future<Robot> fight(final Robot first, final Robot second) {
        final ExecutorService executor = Executors.newSingleThreadExecutor();
        return executor.submit(() -> defineWinner(first, second));
    }

    private Robot defineWinner(final Robot first, final Robot second) {
        final int firstCharacteristic = first.getAttackPower() + first.getDefensePower();
        final int secondCharacteristic = second.getAttackPower() + second.getDefensePower();

        if (firstCharacteristic == secondCharacteristic) {
            return random.nextBoolean() ? first : second;
        }

        return firstCharacteristic > secondCharacteristic ? first : second;
    }
}
