package faang.school.godbless.dolbahlop.multithreading.parallelism;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class ThreadsCalculator implements Runnable{
    private int unitsTotalPower;
    private final List<Unit> units;

    @Override
    public void run() {
        unitsTotalPower = units.stream()
                .mapToInt(Unit::getPower)
                .sum();
    }
}
