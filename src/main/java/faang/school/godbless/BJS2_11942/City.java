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
//                    // нужно посчитать длину вектора от города до монстра или наоборот, неважно
//                    // тут будет округляться но допустим пусть будет только целое расстояние
                    return (int) (CityWorker.getDistanceBetween(monster1, this) - CityWorker.getDistanceBetween(monster2, this));
                }).get();
    }
}
