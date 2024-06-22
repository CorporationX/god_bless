package faang.school.godbless.domain.task_royal_harbor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class King {

    public static void main(String[] args) {

        Knight knightOne = new Knight("Lanselot");
        Knight knightTwo = new Knight("Artur");

        knightOne.addTrial(new Trial(knightOne.getName(), "победить дракона"));
        knightTwo.addTrial(new Trial(knightTwo.getName(), "победить разбойников"));

        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.submit(knightOne::startTrials);
        executor.submit(knightTwo::startTrials);
        executor.shutdown();
    }

}
