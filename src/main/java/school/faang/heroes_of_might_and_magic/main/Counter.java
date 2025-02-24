package school.faang.heroes_of_might_and_magic.main;

import lombok.Getter;
import lombok.Setter;
import school.faang.heroes_of_might_and_magic.groups.Army;
import school.faang.heroes_of_might_and_magic.groups.Squad;
import school.faang.heroes_of_might_and_magic.warriors.Warrior;

import java.util.List;

@Getter
@Setter
public class Counter extends Thread {

    private int squadNumber;
    private int armyPower;

    public Counter(int squadNumber) {
        this.squadNumber = squadNumber;
    }

    @Override
    public void run() {
        Squad armySquad = Army.army.get(squadNumber);
        List<Warrior> squad = armySquad.getWarriors();
        int powerCounter = 0;
        for (Warrior warrior : squad) {
            powerCounter += warrior.getPower();
        }
        System.out.println("Сила отряда с индексом " + squadNumber + ": " + powerCounter);
        setArmyPower(powerCounter);
    }
}
