package school.faang.finger_point_way;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@Slf4j
public class SingleThreadSolution {
    public static void main(String[] args) {
        final Random rand = new Random();
        final int minX = 1;
        final int minY = 1;
        final int maxX = 15;
        final int maxY = 15;
        long startTime = System.nanoTime();
        List<String> cityNames = new ArrayList<>(List.of("Новиград", "Оксенфурт", "Вызима", "Цинтра", "Боклер"));
        List<City> cities = cityNames.stream().map(name -> new City(name, new Location(rand.nextInt(minX, maxX),
                rand.nextInt(minY, maxY)))).toList();
        List<String> monsterNames = new ArrayList<>(List.of("Стрыга", "Упырь", "Леший", "Волколак", "Грифон", "Гуль",
                "Гнилец", "Полуденица", "Экимма", "Катайкан", "Кошмар"));
        List<Monster> monsters = monsterNames.stream().map(name -> new Monster(name, new Location(rand.nextInt(minX, maxX),
                rand.nextInt(minY, maxY)))).toList();

        for (City city : cities) {
            new CityWorker(city, monsters).run();
        }

        long endTime = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startTime);
        log.debug("Main поток отработал, затраченное время: {} миллисекунд", endTime);
        System.out.println(String.format("Main поток отработал, затраченное время: %d миллисекунд", endTime));
    }
}
