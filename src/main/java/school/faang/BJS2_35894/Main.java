package school.faang.BJS2_35894;

import school.faang.BJS2_35894.wars.Archer;
import school.faang.BJS2_35894.wars.Army;
import school.faang.BJS2_35894.wars.Dwarf;
import school.faang.BJS2_35894.wars.Mage;
import school.faang.BJS2_35894.wars.Swordsman;
import school.faang.BJS2_35894.wars.Werewolf;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Army army = new Army();
        army.addUnit(new Archer(25));
        army.addUnit(new Swordsman(40));
        army.addUnit(new Mage(50));
        army.addUnit(new Mage(20));
        army.addUnit(new Dwarf(100));
        army.addUnit(new Werewolf(900));

        int totalPower = army.calculateTotalPower();
        System.out.println("Общая сила армии: " + totalPower);
    }
}