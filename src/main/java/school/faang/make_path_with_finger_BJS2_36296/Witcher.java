package school.faang.make_path_with_finger_BJS2_36296;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Witcher {
    private final static int COUNT_THREADS = 5;
    private final static int AWAITING_TIME = 60;

    private final List<City> cityList = new ArrayList<>(Arrays.asList(
            new City("Camelot", new Location(10.0, 20.0)),
            new City("Vinterhold", new Location(15.0, 25.0))
    ));

    private final List<Monster> monsterList = new ArrayList<>(Arrays.asList(
            new Monster("Viverna", new Location(35.0, 45.0)),
            new Monster("Dragon", new Location(40.0, 50.0)),
            new Monster("Troll", new Location(45.0, 55.0)),
            new Monster("Goblin", new Location(50.0, 60.0)),
            new Monster("Orc", new Location(55.0, 65.0))
    ));

    public static void main(String[] args) {
        Witcher witcher = new Witcher();

        witcher.executeOnMultithreading();
        witcher.executeOnOneThread();
    }

    public void executeOnMultithreading() {
        final double GET_SECOND = 1000;

        ExecutorService executorService = Executors.newFixedThreadPool(COUNT_THREADS);
        long startTime = System.currentTimeMillis();

        cityList.forEach(city ->
                executorService.submit(new CityWorker(city, monsterList))
        );

        executorService.shutdown();
        try {
            if (executorService.awaitTermination(AWAITING_TIME, TimeUnit.SECONDS)) {
                long endTime = System.currentTimeMillis();
                log.info(String.format("Total execution time: %.2f seconds",
                        (endTime - startTime) / GET_SECOND));
            } else {
                System.out.println("Execution interacted");
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void executeOnOneThread() {
        double startTimeOnOneThread = System.currentTimeMillis();
        cityList.forEach(city -> new CityWorker(city, monsterList));
        double endTimeOnOneThread = System.currentTimeMillis();

        log.info(String.format("Total execution time one thread: %.2f seconds",
                (endTimeOnOneThread - startTimeOnOneThread)));
    }
}

