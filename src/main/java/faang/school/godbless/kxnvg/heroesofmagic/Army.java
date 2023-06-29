package faang.school.godbless.kxnvg.heroesofmagic;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class Army {

    private List<Unit> divisions = new ArrayList<>();

    public void addUnit(Unit unit) {
        divisions.add(unit);
    }

    public boolean deleteUnit(Unit unit) {
        if (divisions.contains(unit)) {
            divisions.remove(unit);
            return true;
        } else {
            return false;
        }
    }

    public int totalQuantityUnits() {
        return divisions.size();
    }

    public int calculateTotalPower() {
        ExecutorService service = Executors.newFixedThreadPool(totalQuantityUnits());
        List<PowerThread> threads = new ArrayList<>();
        AtomicInteger result = new AtomicInteger(0);

        divisions.forEach(unit -> threads.add(new PowerThread(unit)));
        threads.forEach(thread -> service.execute(thread));

        service.shutdown();
        threads.forEach(thread -> result.addAndGet(thread.getUnitPower()));
        return result.get();
    }
}
