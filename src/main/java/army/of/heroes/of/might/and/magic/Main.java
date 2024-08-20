package army.of.heroes.of.might.and.magic;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        Army army = new Army();
        army.addUnit(Optional.of(new Archer(25)));
        army.addUnit(Optional.of(new Swordsman(40)));
        army.addUnit(Optional.of(new Mage(50)));
        army.addUnit(Optional.of(new Mage(20)));
        army.addUnit(Optional.of(new Mage(20)));

        int totalPower = army.calculateTotalPower();
        System.out.println("Total army power: " + totalPower);
    }

}
