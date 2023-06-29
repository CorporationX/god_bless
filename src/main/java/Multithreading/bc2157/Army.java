package Multithreading.bc2157;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
@AllArgsConstructor
@Getter
public class Army {
    private List<Hero> armyList;

    public void calculateTotalPower() {

    }

    public void addUnit(Hero unit) {
        getArmyList().add(unit);
    }


}
