package faang.school.godbless.sprint_3.multithreading_parallelism_thread.task_10_coworker;

import java.util.List;

public record CoinCostInc(List<Coin> coins) implements Runnable {

    @Override
    public void run() {
        coins.stream().forEach(c -> {
//            String name = Thread.currentThread().getName();
            c.incCost();
//            System.out.println(name + ": " + c);
        });
    }
}
