package school.faang.kingstourney;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class King {

    public static void main(String[] args) {
        List<Knight> knights = new ArrayList<>();
        Knight lannister = new Knight("Jaime Lannister");
        lannister.addTrial(new Trial(lannister.getName(), "Бой на мечах", 5000));
        lannister.addTrial(new Trial(lannister.getName(), "Метание копья", 2000));
        knights.add(lannister);

        Knight stark = new Knight("Eddard Stark");
        stark.addTrial(new Trial(stark.getName(), "Бой на мечах", 5000));
        stark.addTrial(new Trial(stark.getName(), "Стрельба из лука", 2000));
        knights.add(stark);

        ExecutorService executor = Executors.newFixedThreadPool(2);
        knights.stream()
                .flatMap(knight -> knight.getTrials().stream())
                .forEach(executor::execute);

        executor.shutdown();
        try {
            if (!executor.awaitTermination(10000, TimeUnit.MILLISECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
    }
}
