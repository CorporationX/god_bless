package school.faang.m1.thread.chore;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WeasleyFamily {

    private static final int MAX_WAIT_TIME = 1000000;

    private final List<String> choreList = new ArrayList<>();
    private final ExecutorService executorsService = Executors.newCachedThreadPool();

    public static void main(String[] args) {
        WeasleyFamily weasleyFamily = new WeasleyFamily();
        weasleyFamily.choreList.add("wash dishes");
        weasleyFamily.choreList.add("swipe floor");
        weasleyFamily.choreList.add("cook lunch");
        weasleyFamily.choreList.add("clean windows");
        weasleyFamily.choreList.add("arrange");

        for (String chore : weasleyFamily.choreList) {
            weasleyFamily.executorsService.submit(new Chore(chore));
        }

        gracefullyShutdown(weasleyFamily.executorsService);
    }

    private static void gracefullyShutdown(ExecutorService executor) {
        executor.shutdown();
        try {
            if (!executor.awaitTermination(MAX_WAIT_TIME, TimeUnit.MINUTES)) {
                System.out.println("Не все задачи завершились вовремя, принудительно закрываем пул потоков...");
                executor.shutdownNow();
            } else {
                System.out.println("Все задачи выполнены успешно.");
            }
        } catch (InterruptedException e) {
            System.out.println("Главный поток был прерван.");
            executor.shutdownNow();
        }
    }
}
