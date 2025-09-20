package school.faang.multithreading_parallelism_thread.bgs2_89758;

import java.util.List;

import static school.faang.multithreading_parallelism_thread.bgs2_89758.Utils.measureExecutionTime;

public class Main {
    public static void main(String[] args) {
        List<RocketLaunch> launches = List.of(
                new RocketLaunch("Мираж", 4233L),
                new RocketLaunch("Сияние", 3324L),
                new RocketLaunch("Воздух", 1223L),
                new RocketLaunch("Казань", 1800L),
                new RocketLaunch("Москва", 4556L),
                new RocketLaunch("Озерки", 336L),
                new RocketLaunch("Восток", 2105L),
                new RocketLaunch("Север", 3890L),
                new RocketLaunch("Сокол", 2745L),
                new RocketLaunch("Орион", 5012L),
                new RocketLaunch("Вега", 1430L),
                new RocketLaunch("Пегас", 3678L),
                new RocketLaunch("Тайфун", 612L),
                new RocketLaunch("Зенит", 2950L),
                new RocketLaunch("Аврора", 4201L),
                new RocketLaunch("Прометей", 3589L),
                new RocketLaunch("Атлант", 2417L),
                new RocketLaunch("Буран", 1986L),
                new RocketLaunch("Факел", 3233L),
                new RocketLaunch("Меридиан", 2777L)
        );


        long leadTimeMs = measureExecutionTime(() -> RocketLaunch.planRocketLaunches(launches));
        System.out.printf("Время выполнения всех полетов: %d мс%n", leadTimeMs);
    }
}
