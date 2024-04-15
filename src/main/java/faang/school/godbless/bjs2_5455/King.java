package faang.school.godbless.bjs2_5455;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class King {

    private final static List<Knight> knights = new ArrayList<>();

    public static void main(String[] args) {
        Knight johnSnow = new Knight("John Snow");
        Knight jaimeLannister = new Knight("Jaime Lannister");

        Trial trialForJohnSnow1 = new Trial(johnSnow.getName(), "Hit the target with a bow");
        Trial trialForJohnSnow2 = new Trial(johnSnow.getName(), "Run 10 km");

        Trial trialForJaimeLannister1 = new Trial(jaimeLannister.getName(), "Drink 10 liters of beer");
        Trial trialForJaimeLannister2 = new Trial(jaimeLannister.getName(), "Defeat 10 knights");

        johnSnow.addTrial(trialForJohnSnow1);
        johnSnow.addTrial(trialForJohnSnow2);
        jaimeLannister.addTrial(trialForJaimeLannister1);
        jaimeLannister.addTrial(trialForJaimeLannister2);

        knights.add(johnSnow);
        knights.add(jaimeLannister);

        startTrials();
    }

    public static void startTrials() {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        knights.stream()
                .flatMap(knight -> knight.getTrials().stream())
                .forEach(executorService::submit);
        executorService.shutdown();
    }
}
