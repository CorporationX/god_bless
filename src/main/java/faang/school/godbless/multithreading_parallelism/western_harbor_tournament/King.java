package faang.school.godbless.multithreading_parallelism.western_harbor_tournament;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class King {
    public static void main(String[] args) {
        Knight firstKnight = new Knight("Kirill");
        Knight secondKnight = new Knight("Yaroslav");
        List<Knight> knightList = List.of(firstKnight, secondKnight);
        for (int i = 0; i < knightList.size(); i++) {
            Knight knight = knightList.get(i);
            knight.addTrial(new Trial(knight.getName(), "Смертельная тропа"));
            knight.addTrial(new Trial(knight.getName(), "Коварный варвар"));
        }

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        for (Knight knight : knightList) {
            executorService.submit(knight.startTrials());
        }
        executorService.shutdown();
    }
}
