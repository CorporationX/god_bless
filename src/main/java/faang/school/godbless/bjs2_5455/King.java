package faang.school.godbless.bjs2_5455;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class King {

    private static final String JOHN_SNOW = "John Snow";
    private static final String JAIME_LANNISTER= "Jaime Lannister";

    private final static List<Knight> knights = new ArrayList<>();

    public static void main(String[] args) {
        Knight johnSnow = new Knight(JOHN_SNOW);
        johnSnow.addTrial(new Trial(JOHN_SNOW, "Hit the target with a bow"));
        johnSnow.addTrial(new Trial(JOHN_SNOW, "Run 10 km"));
        knights.add(johnSnow);

        Knight jaimeLannister = new Knight(JAIME_LANNISTER);
        jaimeLannister.addTrial(new Trial(JAIME_LANNISTER, "Drink 10 liters of beer"));
        jaimeLannister.addTrial(new Trial(JAIME_LANNISTER, "Defeat 10 knights"));
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
