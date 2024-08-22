package faang.school.godbless.BJS2_23547;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class King {
    public static void main(String[] args) {

        List<Knight> knights = new ArrayList<>(Arrays.asList(
                new Knight("John Snow"),
                new Knight("Jaime Lannister")
        ));

        knights.get(0).addTrial(new Trial(knights.get(0).getName(), "Kill the dragon"));
        knights.get(0).addTrial(new Trial(knights.get(0).getName(), "Kill the lion"));

        knights.get(1).addTrial(new Trial(knights.get(1).getName(), "Kill the bull"));
        knights.get(1).addTrial(new Trial(knights.get(1).getName(), "Kill the direwolf"));

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        for(var knight : knights) {
            executorService.submit(knight);
        }

        executorService.shutdown();
    }
}
