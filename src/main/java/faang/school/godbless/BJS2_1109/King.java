package faang.school.godbless.BJS2_1109;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class King {
    public static void main(String[] args) {
        List<Trial> listOfTrials = new ArrayList<>();
        Knight knight = new Knight("Arthur");
        Knight knight1 = new Knight("Jessep");

        Trial trial = new Trial(knight1.getName(), "battle with dragon");
        Trial trial1 = new Trial(knight.getName(), "10km run marathon");

        knight.addTrial(trial, listOfTrials);
        knight.addTrial(trial1, listOfTrials);

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        knight.startTrials(executorService);
        knight1.startTrials(executorService);
        executorService.shutdown();
    }
}
