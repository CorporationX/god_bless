package school.faang;

import school.faang.Fighter.Archer;
import school.faang.Fighter.Mage;
import school.faang.Fighter.Swordsman;

public class Main {
    public static void main(String[] args){
        Army army = new Army();
        army.addUnit(new Archer());
        army.addUnit(new Swordsman());
        army.addUnit(new Mage());
        army.addUnit(new Mage());

        int totalPower = army.calculateTotalPower();
        System.out.println("Army strength " + totalPower);
    }

}