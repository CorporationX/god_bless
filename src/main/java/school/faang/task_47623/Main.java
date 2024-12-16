package school.faang.task_47623;

import lombok.extern.slf4j.Slf4j;
import school.faang.task_47623.model.Archer;
import school.faang.task_47623.model.Mage;
import school.faang.task_47623.model.Swordsman;

@Slf4j
public class Main {
    public static void main(String[] args) {
        Army army = new Army();

        army.addCharacter(new Archer(25));
        army.addCharacter(new Swordsman(40));
        army.addCharacter(new Mage(50));
        army.addCharacter(new Mage(20));

        log.info("Army total power: {}", army.calculateTotalPower());
    }
}
