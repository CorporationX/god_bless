package faang.school.godbless.sword_and_magic;

import faang.school.godbless.sword_and_magic.units.Unit;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Getter
@RequiredArgsConstructor
public class UnitThread extends Thread {
    private final List<Unit> squad;
    private final AtomicInteger totalPower;

    public void run() {
        int squadPower = squad.stream()
                .mapToInt(Unit::getPower)
                .sum();
        totalPower.addAndGet(squadPower);
    }
}
