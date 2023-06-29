package faang.school.godbless.distributedArmy;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Army {
    private List<Archer> archers = new ArrayList<>();
    private List<Swordsman> swordsman = new ArrayList<>();
    private List<Mage> mages = new ArrayList<>();

    public void addArcher(Archer archer) {
        archers.add(archer);
    }

    public void addSwordsman(Swordsman swordsman) {
        this.swordsman.add(swordsman);
    }

    public void addMage(Mage mage) {
        mages.add(mage);
    }

    public int calculateTotalPower() {
        ExecutorService executorService = Executors.newCachedThreadPool();
        List<Future<Integer>> results = new ArrayList<>();

        for (Archer archer : archers) {
            Callable<Integer> task = archer::getPower;
            Future<Integer> result = executorService.submit(task);
            results.add(result);
        }

        for (Swordsman swordsman : swordsman) {
            Callable<Integer> task = swordsman::getPower;
            Future<Integer> result = executorService.submit(task);
            results.add(result);
        }

        for (Mage mage : mages) {
            Callable<Integer> task = mage::getPower;
            Future<Integer> result = executorService.submit(task);
            results.add(result);
        }

        int totalPower = 0;
        for (Future<Integer> result : results) {
            try {
                totalPower += result.get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        executorService.shutdown();

        return totalPower;
    }
}
