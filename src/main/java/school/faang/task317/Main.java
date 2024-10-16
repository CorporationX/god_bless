package school.faang.task317;

import school.faang.task317.kingdom.Knight;
import school.faang.task317.kingdom.Trial;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Knight firstKnight = new Knight("Ланцелот");
        Knight secondKnight = new Knight("Геральт");

        Trial firstTrial = new Trial(firstKnight.getName(),"Полоса препятствий");
        Trial secondTrial = new Trial(firstKnight.getName(),"Сражение со львом");

        Trial thirdTrial = new Trial(secondKnight.getName(),"Пол это лава");
        Trial fourthTrial = new Trial(secondKnight.getName(),"Поединок");

        Stream.of(firstTrial,secondTrial).peek(firstKnight::addTrial).collect(Collectors.toList());
        Stream.of(thirdTrial,fourthTrial).peek(secondKnight::addTrial).collect(Collectors.toList());

        ExecutorService executor= Executors.newFixedThreadPool(2);

        firstKnight.startTrial(executor);
        secondKnight.startTrial(executor);

        executor.shutdown();

        if(!executor.awaitTermination(1, TimeUnit.MINUTES)){
            executor.shutdown();
            System.out.println("Ошибка испытания не смогли завершиться");
        }
        else {
            System.out.println("Испытания завершены");
        }
    }
}
