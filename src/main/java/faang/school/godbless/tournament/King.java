package faang.school.godbless.tournament;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class King {

    public static void main(String[] args) {
        List<Knight> knights = List.of(new Knight("Leon"), new Knight("Scott"));
        for (int i = 0; i < knights.size(); i++) {
            Knight knight = knights.get(i);
            knight.addTrial(new Trial(knight.getName(), "Trial " + (2 * i + 1)));
            knight.addTrial(new Trial(knight.getName(), "Trial " + (2 * i + 2)));
        }
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        knights.stream()
                .flatMap(knight -> knight.getTrials().stream())
                .forEach(executorService::submit);
        executorService.shutdown();
    }
}