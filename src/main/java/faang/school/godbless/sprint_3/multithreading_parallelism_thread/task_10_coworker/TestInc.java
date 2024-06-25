package faang.school.godbless.sprint_3.multithreading_parallelism_thread.task_10_coworker;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class TestInc {
    private static final int COUNT_COIN = 10_000_000;
    private static final int COUNT_THREAD = 10;
    private static final int STEP = COUNT_COIN / COUNT_THREAD;
    private static final String MSG_END = "Работа закончена.";

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(COUNT_THREAD);
        List<Coin> coins = createCoinList();

        executeCoinCostInc(executor, coins);

        executor.shutdown();

        try {
            executor.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(MSG_END);
    }

    private static void executeCoinCostInc(ExecutorService executor, List<Coin> coins) {
        int startIndex = 0;

        for (int i = 0; i < COUNT_THREAD; i++, startIndex += STEP) {
            if (i + 1 >= COUNT_THREAD) {
                executor.execute(new CoinCostInc(coins.subList(startIndex, COUNT_COIN)));
                break;
            }
            executor.execute(new CoinCostInc(coins.subList(startIndex, startIndex + STEP)));
        }
    }

    private static List<Coin> createCoinList() {
        List<Coin> coins = new ArrayList<>();

        for (int i = 0; i < COUNT_COIN; i++) {
            coins.add(new Coin());
        }

        return coins;
    }
}
