package faang.school.multithreadingparallelismthread.distributedarmyofheroes;

import faang.school.multithreadingparallelismthread.distributedarmyofheroes.entityes.Unit;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Army {

    private final List<Unit> units = new ArrayList<>();

    public int calculateTotalPower() throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(units.size());

        int totalPower = 0;

        for (Unit unit : units) {
            totalPower += executor.submit(unit::getPower).get();
        }

        executor.shutdown();

        return totalPower;
    }

    public void addArmy(Unit unit) {
        if (unit != null) {
            units.add(unit);
        }
    }
}
