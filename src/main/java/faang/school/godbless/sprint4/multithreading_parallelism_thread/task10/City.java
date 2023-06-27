package faang.school.godbless.sprint4.multithreading_parallelism_thread.task10;

import java.util.ArrayList;
import java.util.List;

public class City {

    private String cityName;

    private int durationToNovigrad;
    private int durationToOxenfurt;
    private int durationToVizima;
    private int durationToKaerMorhen;

    private City(){}

    private City(String cityName, int durationToNovigrad, int durationToOxenfurt, int durationToVizima, int durationToKaerMorhen) {
        this.cityName = cityName;
        this.durationToNovigrad = durationToNovigrad;
        this.durationToOxenfurt = durationToOxenfurt;
        this.durationToVizima = durationToVizima;
        this.durationToKaerMorhen = durationToKaerMorhen;
    }

    public static List<City> getCityList(){
        List<City> cities = new ArrayList<>();

        cities.add(new City("Novigrad", 0, 60, 120, 180));
        cities.add(new City("Oxenfurt", 60, 0, 50, 70));
        cities.add(new City("Vizima", 120, 50, 0, 30));
        cities.add(new City("Kaer Morhen", 180, 70, 30, 0));

        return cities;
    }
}
