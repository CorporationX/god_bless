package faang.school.godbless.game.of.the.trons;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class King {
    public static void main(String[] args) {
        Knight knightOne = new Knight("Artur");
        Knight knightTwo = new Knight("Jon");
        knightOne.addTrialList(new Trial(knightOne.getName(), "Убей скалу"));
        knightOne.addTrialList(new Trial(knightOne.getName(), "Убей всех"));
        knightTwo.addTrialList(new Trial(knightTwo.getName(), "Останови ходоков"));
        knightTwo.addTrialList(new Trial(knightTwo.getName(), "Убей Дейнерис"));
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Knight.startTrial(executorService);
    }
}
