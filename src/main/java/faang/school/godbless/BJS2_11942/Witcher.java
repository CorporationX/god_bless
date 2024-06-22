package faang.school.godbless.BJS2_11942;

import lombok.Getter;

import java.util.List;

@Getter
public class Witcher extends Creature {
    private final List<City> citiesToGo;

    public Witcher(String name, Location location, List<City> citiesToGo) {
        super(name, location);
        this.citiesToGo = citiesToGo;
    }

    public void walkToCity(City city) {
        System.out.println("Поход ведьмака " + name +  " в город " + city.getName() + "...");
        // дистанция - время на поход
        doAction(CityWorker.getDistanceBetween(this, city));
        System.out.println("Поход ведьмака " + name +  " в город " + city.getName() + " завершен");
    }

    public void goToMonster(Monster monster) {
        System.out.println("Охота ведьмака " + name + " на монстра " + monster.getName());
        doAction(CityWorker.getDistanceBetween(this, monster));
        System.out.println("Монстр " + monster.getName() + " найден ведьмаком " + name);
    }

    public void killMonster(Monster monster) {
        System.out.println("Сражение ведьмака " + name + " с монстром " + monster.getName() + "...");
        doAction(monster.getKillTime());
        System.out.println(name + " победил монстра " + monster.getName());
    }
}
