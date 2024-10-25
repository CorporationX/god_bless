package school.faang.sprint_3.heroes;

import school.faang.sprint_3.heroes.units.Archer;
import school.faang.sprint_3.heroes.units.Centaur;
import school.faang.sprint_3.heroes.units.Mage;
import school.faang.sprint_3.heroes.units.Swordsman;

public class Main {
    public static void main(String[] args) {
        Army army = new Army();
        army.addUnits(new Archer(25));
        army.addUnits(new Mage(50));
        army.addUnits(new Swordsman(40));
        army.addUnits(new Centaur(15));
        army.addUnits(new Centaur(15));
        army.addUnits(new Swordsman(40));
        army.addUnits(new Archer(25));

        int totalPower = army.calculateTotalPower();
        System.out.println("Общая сила армии: " + totalPower);
    }
}
