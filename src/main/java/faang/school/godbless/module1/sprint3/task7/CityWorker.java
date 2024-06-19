package faang.school.godbless.module1.sprint3.task7;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;


@Getter
@AllArgsConstructor
public class CityWorker implements Runnable {
    private City city;
    private List<Monster> monsters;


    @Override
    public void run() {
        System.out.println("Nearest monster to the " + city.getName() + " is "
               + findNearestMonster().getName());
    }


    public Monster findNearestMonster(){

        List<Integer> distances = new ArrayList<>();
        monsters.forEach(monster ->distances.add((int) Math.abs(
                Math.sqrt(
                        Math.pow(monster.getCityLocation().getLongitude() - city.getLocation().getLongitude(), 2) +
                                Math.pow(monster.getCityLocation().getWidth() - city.getLocation().getWidth(), 2)))));

        return monsters.get(distances.indexOf(distances.stream().min((Integer::compareTo)).orElse(0)));
    }

}
