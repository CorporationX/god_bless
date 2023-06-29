package kings_landing_tournament;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class King {
    public static void main(String[] args) {
        Knight knightOne = new Knight("Вася");
        knightOne.addTrial(new Trial("почистить картошку"));
        knightOne.addTrial(new Trial("вспахать огород"));

        Knight knightTwo = new Knight("Петя");
        knightTwo.addTrial(new Trial("помыть посуду"));
        knightTwo.addTrial(new Trial("постирать вещи"));

        List<Knight> knights = List.of(knightOne, knightTwo);

        ExecutorService service = Executors.newFixedThreadPool(2);
        for (var knight: knights){
            service.submit(knight::startTrials);
        }

        service.shutdown();
        try {
            if (service.awaitTermination(1, TimeUnit.MINUTES)){
                System.out.println("испытания прошли успешно");
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
