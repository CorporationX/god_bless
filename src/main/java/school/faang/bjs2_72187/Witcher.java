package school.faang.bjs2_72187;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Witcher {
    //Создать списки городов и монстров.

    //Использовать ExecutorService для создания пула потоков.

    //Для каждого города создать объект CityWorker и передать его в пул потоков.

    //После завершения всех потоков, вывести общее время выполнения программы.

    //Провести сравнение времени выполнения программы в однопоточном и многопоточном режимах,
    //а также при разном количестве потоков.

    public static void main(String[] args) {
        List<City> cities = List.of(
            new City("Kallax", new Location(3, 10)),
            new City("Bodviken", new Location(4, 6)),
            new City("Voxnan", new Location(5, 1)),
            new City("Holjesl", new Location(10, 7)),
            new City("Toftan", new Location(11, 1)),
            new City("Rimforsa", new Location(14, 2))
        );

        List<Monster> monsters = List.of(
            new Monster("Malm", new Location(1, 6)),
            new Monster("Brimnes", new Location(2, 2)),
            new Monster("Hauga", new Location(4, 8)),
            new Monster("Idanas", new Location(4, 11)),
            new Monster("Songesand", new Location(5, 4)),
            new Monster("Bruksvara", new Location(8, 9)),
            new Monster("Flintan", new Location(8, 6)),
            new Monster("Langfjall", new Location(9, 3)),
            new Monster("Laktare", new Location(11, 9)),
            new Monster("Kungsfors", new Location(12, 7)),
            new Monster("Sunnersta", new Location(12, 2)),
            new Monster("Hultarp", new Location(13, 4)),
            new Monster("Variera", new Location(15, 5)),
            new Monster("Hornavan", new Location(16, 1))
        );

        Location witcherLocation = new Location(0, 0);
        ExecutorService executor = Executors.newCachedThreadPool();
        for (City city : cities) {
            CityWorker cityWorker = new CityWorker(witcherLocation, city, monsters);
            executor.execute(cityWorker);
        }
        executor.shutdown();
        try {
            if (!executor.awaitTermination(1, TimeUnit.MINUTES)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
    }
}
