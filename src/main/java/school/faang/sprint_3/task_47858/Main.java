package school.faang.sprint_3.task_47858;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    public static void main(String[] args) {
        Army army = new Army();

        try {
            army.addUnit(new Archer(25));
            army.addUnit(new Swordsman(40));
            army.addUnit(new Mage(50));
            army.addUnit(new Mage(20));

            System.out.println("Total strength of the army: " + army.calculateTotalPower());
        } catch (InterruptedException e) {
            log.error(e.getMessage());
        }
    }
}
