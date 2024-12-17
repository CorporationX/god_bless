package school.faang.sprint3.bjs_47652;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    public static void main(String[] args) {
        Army army = new Army();
        army.addUnit(new Mage(25));
        army.addUnit(new Archer(12));
        army.addUnit(new Mage(60));
        army.addUnit(new Swordsman(80));
        army.addUnit(new Archer(70));
        army.addUnit(new Swordsman(40));

        log.info("Total power of army : {} ", army.calculateTotalPower());
    }
}