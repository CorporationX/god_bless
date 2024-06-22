package faang.school.godbless.BJS2_11942;

/*
    Переработал задачу: теперь я буду для работы с каждым
    ведьмаком используется класс CityWorker в котором в методе run выполняются действия:
      поиск расстояния от города до ведьмака
      поход в город
      поиск расстояния до ближайшего монстра от города
      поход к ближайшему монстру
      сражение с ближайшим с монстром (перед этим высчитывается время борьбы)
    И так будет делать каждый ведьмак в отдельном потоке для каждого города
    Ведьмаков будет 200
 */

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// время не замерить тк имитация действия это слип потока со случайным значением
public class Main {
    public static final int NUM_THREADS = 15;
    public static final int NUM_CITIES = 421;
    public static final int NUM_MONSTERS = 412;
    public static final int NUM_WITCHERS = 41;
    public static void main(String[] args) {
        // создаю и инициализирую лист из 200 монстров
        List<Monster> monsters = new ArrayList<>();

        for (int i = 1; i < NUM_MONSTERS + 1; i++) {
            monsters.add(new Monster("Monster " + i, new Location(Math.random() * 500 + 1, Math.random() * 500 + 1)));
        }

        // создаю и инициализирую лист из 200 городов
        // один список будет на всех ведьмаков пожалете минья я эту задачу 2 часа делаъю((
        List<City> cities = new ArrayList<>();

        for (int i = 1; i < NUM_CITIES + 1; i++) {
            cities.add(new City("City " + i, new Location(Math.random() * 500 + 1, Math.random() * 500 + 1), monsters));
        }

        // создаю и инициализирую лист из 200 ведьмаков
        List<Witcher> witchers = new ArrayList<>();

        for (int i = 1; i < NUM_WITCHERS + 1; i++) {
            witchers.add(new Witcher("Witcher " + i, new Location(Math.random() * 500 + 1, Math.random() * 500 + 1), cities));
        }

        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);

        for (var witcher: witchers) {
            executorService.submit(new CityWorker(witcher));
        }

        executorService.shutdown();
    }
}
