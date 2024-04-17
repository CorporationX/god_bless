package faang.school.godbless.parallelism.heroesOfMightAndMagic;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    public static void main(String[] args) {
        Army army = new Army();
        army.addUnit(new Archer(25)); // считаем в потоке 1
        army.addUnit(new Swordsman(40)); // считаем в потоке 2
        army.addUnit(new Mage(50)); // считаем в потоке 3
        army.addUnit(new Mage(20)); // считаем в потоке 4

        int totalPower = army.calculateTotalPower();
        log.info("Total army power: " + totalPower);
    }
}
