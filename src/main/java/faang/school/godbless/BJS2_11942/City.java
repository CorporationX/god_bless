package faang.school.godbless.BJS2_11942;


import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class City {
    private String name;
    private Location location;
    private List<Monster> cityMonsters;

    public Monster getNearestMonster() {

        return cityMonsters.stream()
                .min((monster1, monster2) -> {
                    // нужно посчитать длину вектора от города до монстра или наоборот, неважно
                    double monster2Distance = Math.sqrt(Math.pow(monster2.getLocation().getXCord() - location.getXCord(), 2) + Math.pow(monster2.getLocation().getYCord() - location.getYCord(), 2));
                    double monster1Distance = Math.sqrt(Math.pow(monster1.getLocation().getXCord() - location.getXCord(), 2) + Math.pow(monster1.getLocation().getYCord() - location.getYCord(), 2));

                    // тут будет округляться но допустим пусть будет только целое расстояние
                    return (int) (monster1Distance - monster2Distance);
                }).get();
    }
}
