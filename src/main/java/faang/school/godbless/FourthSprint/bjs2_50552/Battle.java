package faang.school.godbless.FourthSprint.bjs2_50552;

import lombok.Getter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Getter
public class Battle {

    private final ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    public Future<Robot> fight(Robot first, Robot second) {
        Future<Robot> result = executor.submit(() -> {
            int firstPower = first.getAttackPower() + first.getDefencePower();
            int secondPower = second.getAttackPower() + second.getDefencePower();

            if (firstPower == secondPower) secondPower += Math.random() > 0.5 ? 1 : -1;
            return firstPower < secondPower ? second : first;
        });
        return result;
    }
}
