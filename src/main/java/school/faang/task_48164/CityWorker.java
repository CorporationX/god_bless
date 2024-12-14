package school.faang.task_48164;

import java.util.List;

public record CityWorker(City city, List<Monster> monsters) implements Runnable {
    private static final Location WITCHER_LOCATION = new Location(0, 0);

    @Override
    public void run() {
        int catheterFirst = city.getLocation().getCoordinateX(); //b
        int catheterSecond = city.getLocation().getCoordinateY(); //a

        double hypotenuse = Math.sqrt(Math.pow(catheterFirst, 2) + Math.pow(catheterSecond, 2));
        System.out.printf("The path from Witcher to city is %.2f km\n", hypotenuse);

        double minPathToMonster = monsters.stream()
                .map((monster) -> Math.sqrt(Math.pow(Math.abs(monster.getLocation().getCoordinateX() - city.getLocation().getCoordinateY()), 2)
                        + Math.pow(Math.abs(monster.getLocation().getCoordinateY() - city.getLocation().getCoordinateY()), 2)))
                .min(Double::compare).orElse(Double.MIN_VALUE);

        System.out.printf("The nearest monster from the city %s is about %.2f km\n", city.getName(), minPathToMonster);
        System.out.printf("So the all path for you will be about %.2f km\n", minPathToMonster + hypotenuse);
    }
}