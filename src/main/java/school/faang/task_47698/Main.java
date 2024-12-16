package school.faang.task_47698;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    private static final Army army = new Army();

    private static final int ARCHERS_COUNT = 20;
    private static final int CAVALRIES_COUNT = 25;
    private static final int MAGES_COUNT = 5;
    private static final int SWORDSMEN_COUNT = 33;

    public static void main(String[] args) throws InterruptedException {
        initData();
        log.info("army.calculateTotalPower() = {}", army.calculateTotalPower());
    }

    private static void initData() {
        for (int i = 0; i < ARCHERS_COUNT; i++) {
            army.addUnit(new Archer());
        }
        for (int i = 0; i < CAVALRIES_COUNT; i++) {
            army.addUnit(new Cavalry());
        }
        for (int i = 0; i < MAGES_COUNT; i++) {
            army.addUnit(new Mage());
        }
        for (int i = 0; i < SWORDSMEN_COUNT; i++) {
            army.addUnit(new Swordsman());
        }
    }

}
