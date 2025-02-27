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
    private Army army;

    public Counter(int squadNumber, Army army) {
        this.squadNumber = squadNumber;
        this.army = army;
    }

    @Override
    public void run() {
        Squad armySquad = army.getArmy().get(squadNumber);
        int squadPower = armySquad.calculateSquadPower();
        System.out.println("Сила отряда с индексом " + squadNumber + ": " + squadPower);
        army.setArmyPower(squadPower + army.getArmyPower());
    }
}
