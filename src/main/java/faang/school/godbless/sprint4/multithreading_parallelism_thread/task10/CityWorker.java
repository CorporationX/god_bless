package faang.school.godbless.sprint4.multithreading_parallelism_thread.task10;

import java.util.List;

public class CityWorker implements Runnable {

    private List<City> cities;

    private List<Monster> monsters;

    private City city;

    public CityWorker(List<City> cities, List<Monster> monsters, City city) {
        this.cities = cities;
        this.monsters = monsters;
        this.city = city;
    }

    @Override
    public void run() {
        searchNearestMonster();
    }

    private void searchNearestMonster() {
        int minDuration = -1;
        for (int i = 0; i < cities.size(); i++) {

        }
    }
}
