package witchergeralt;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class Witcher {
    private static final Logger logger = Logger.getLogger(Witcher.class.getName());

    public static void main(String[] args) throws InterruptedException {
        List<Monster> monsters = Arrays.asList(
                new Monster("Wolf", new Location(5, 7)),
                new Monster("Dragon", new Location(10, 15)),
                new Monster("Vampire", new Location(3, 4))
        );

        List<City> cities = Arrays.asList(
                new City("Novigrad", new Location(1, 2)),
                new City("Oxenfurt", new Location(8, 9)),
                new City("Cintra", new Location(4, 6))
        );

        int numberOfProcessors = Runtime.getRuntime().availableProcessors();
        ExecutorService executorService = Executors.newFixedThreadPool(numberOfProcessors);

        for (City city : cities) {
            CityWorker cityWorker = new CityWorker(city, monsters);
            executorService.submit(cityWorker);
        }
        executorService.shutdown();
        if (!executorService.awaitTermination(60, TimeUnit.SECONDS)) {
            logger.warning("Magic map didn't complete the search within the timeout!");
            executorService.shutdownNow();
            if (!executorService.awaitTermination(30, TimeUnit.SECONDS)) {
                logger.severe("Some tasks were not completed after shutdownNow!");
            }
        } else {
            logger.info("All searches completed successfully!");
        }
    }
}