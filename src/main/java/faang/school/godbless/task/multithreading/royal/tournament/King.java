package faang.school.godbless.task.multithreading.royal.tournament;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class King {
    private static final int THREADS_POOL_LIMIT = 2;

    public static void main(String[] args) {
        var knight1 = new Knight("Клиган");
        knight1.addTrial(new Trial(knight1.getName(), "Собрать 30 одуванчиков"));
        knight1.addTrial(new Trial(knight1.getName(), "5 минут не убивать простолюдинов"));
        var knight2 = new Knight("Пёс");
        knight2.addTrial(new Trial(knight2.getName(), "Поймать 5 стрекоз"));
        knight2.addTrial(new Trial(knight2.getName(), "Испечь 3 блина в форме радуги"));
        List<Knight> knights = List.of(knight1, knight2);

        ExecutorService executorService = Executors.newFixedThreadPool(THREADS_POOL_LIMIT);
        IntStream.range(0, knights.size())
                .forEach(i -> {
                    executorService.submit(() -> knights.get(i).startTrials());
                });
        executorService.shutdown();
    }
}
