package school.faang;

import school.faang.Fighter.Archer;
import school.faang.Fighter.Mage;
import school.faang.Fighter.Swordsman;

public class Main_1 {
    public static void main(String[] args){
        Army army = new Army();
        for (int i = 0; i < 2; i++) {
            army.addUnit(new Mage());
            army.addUnit(new Archer());
        }
        army.addUnit(new Swordsman());

        int totalPower = army.calculateTotalPower();
        System.out.println("Army strength " + totalPower);
    }

}