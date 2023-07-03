package faang.school.godbless.homm;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

@AllArgsConstructor
public class Army {

    private List<Hero> heroes;

    public int calculateTotalPower() {
        AtomicInteger totalPower = new AtomicInteger(0);
        if (heroes.size() != 0) {
            ExecutorService service = Executors.newFixedThreadPool(heroes.size());
            heroes.forEach(hero -> totalPower.addAndGet(hero.getPower()));
            service.shutdown();
        }
        return totalPower.get();
    }
}

