package school.faang.BJS2_35894;

import school.faang.BJS2_35894.wars.Archer;
import school.faang.BJS2_35894.wars.Army;
import school.faang.BJS2_35894.wars.Dwarf;
import school.faang.BJS2_35894.wars.Mage;
import school.faang.BJS2_35894.wars.Swordsman;
import school.faang.BJS2_35894.wars.Werewolf;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) throws InterruptedException {
        try {
            Army army = new Army();
            army.addUnit(new Archer(25));
            army.addUnit(new Swordsman(40));
            army.addUnit(new Mage(50));
            army.addUnit(new Mage(20));
            army.addUnit(new Dwarf(100));
            army.addUnit(new Werewolf(900));

            int totalPower = army.calculateTotalPower();
            System.out.println("Общая сила армии: " + totalPower);
        } catch (InterruptedException e) {
            LOGGER.log(Level.SEVERE, "Ошибка в главном потоке программы", e);
            throw e;
        }
    }
}