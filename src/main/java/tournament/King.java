package tournament;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class King {
    public static void main(String[] args) {
        Knight knightGeorg = new Knight("Georg");
        Knight knightMarshal = new Knight("Marshal");

        knightGeorg.addTrial(new Trial(knightGeorg.getName(), "пойти туда не знаю куда"));
        knightGeorg.addTrial(new Trial(knightGeorg.getName(), "пойти туда не знаю куда"));
        knightGeorg.addTrial(new Trial(knightGeorg.getName(), "пойти туда не знаю куда"));
        knightGeorg.addTrial(new Trial(knightGeorg.getName(), "пойти туда не знаю куда"));
        knightMarshal.addTrial(new Trial(knightMarshal.getName(), "найти то не знаю что"));
        knightMarshal.addTrial(new Trial(knightMarshal.getName(), "найти то не знаю что"));
        knightMarshal.addTrial(new Trial(knightMarshal.getName(), "найти то не знаю что"));
        knightMarshal.addTrial(new Trial(knightMarshal.getName(), "найти то не знаю что"));
        knightMarshal.addTrial(new Trial(knightMarshal.getName(), "найти то не знаю что"));
        ExecutorService execute = Executors.newFixedThreadPool(2);

        knightGeorg.startTrial(execute);
        knightMarshal.startTrial(execute);
        try {
            if (!execute.awaitTermination(800, TimeUnit.MILLISECONDS)) {
                System.out.println("Программа завершена!");
                execute.shutdown();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
