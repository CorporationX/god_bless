package school.faang.naughtwoBJS261388;

import school.faang.naughtwoBJS261388.fighters.Archer;
import school.faang.naughtwoBJS261388.fighters.Mage;
import school.faang.naughtwoBJS261388.fighters.Swordsman;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Army army = new Army();

        Squad archers = new Squad("Archers", List.of(new Archer(25), new Archer(30)));
        Squad swordsmen = new Squad("Swordsman", List.of(new Swordsman(40), new Swordsman(35)));
        Squad mages = new Squad("Magicians", List.of(new Mage(50), new Mage(45)));

        army.addSquad(archers);
        army.addSquad(swordsmen);
        army.addSquad(mages);

        int totalPower = army.calculateTotalPower();
        System.out.printf("Total power: %d%n", totalPower);
    }
}

