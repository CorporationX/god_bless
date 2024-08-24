package faang.school.godbless.sprint.three.heroes;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Getter
public class PowerThread extends Thread {
    private final List<Unit> units = new ArrayList<>();
    private final AtomicInteger allPowers;

    public PowerThread(AtomicInteger allPowers) {
        this.allPowers = allPowers;
    }

    public void addUnit(Unit unit) {
        this.units.add(unit);
    }

    @Override
    public void run() {
        try {
            Thread.sleep(500);
            System.out.println(Thread.currentThread().getName() + "run");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        this.allPowers.addAndGet(
                this.units.stream()
                        .mapToInt(Unit::getPower).sum()
        );
    }
}
