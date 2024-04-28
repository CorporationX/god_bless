package faang.school.godbless.multithreading_parallelism.BJS2_6218;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class King {
    private static final String JOHN_SNOW = "John Snow";
    private static final String NED_STARK = "Ned Stark";
    private final static List<Knight> knights = new ArrayList<>();

    public static void main(String[] args) {
        Knight johnSnow = new Knight(JOHN_SNOW);
        johnSnow.addTrial(new Trial(JOHN_SNOW, "Get the gold sword"));
        johnSnow.addTrial(new Trial(JOHN_SNOW, "Swim 100 km"));
        knights.add(johnSnow);

        Knight jaimeLannister = new Knight(NED_STARK);
        jaimeLannister.addTrial(new Trial(NED_STARK, "Knightly Fashion Show"));
        jaimeLannister.addTrial(new Trial(NED_STARK, "Squire for a Day"));
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
