package school.faang.task_47698;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    private static final Army army = new Army();

    private static final int archersCount = 20;
    private static final int cavalriesCount = 25;
    private static final int magesCount = 5;
    private static final int swordsmenCount = 33;

    public static void main(String[] args) throws InterruptedException {
        initData();
        log.info("army.calculateTotalPower() = {}", army.calculateTotalPower());
    }

    private static void initData() {
        for (int i = 0; i < archersCount; i++) {
            army.addUnit(new Archer());
        }
        for (int i = 0; i < cavalriesCount; i++) {
            army.addUnit(new Cavalry());
        }
        for (int i = 0; i < magesCount; i++) {
            army.addUnit(new Mage());
        }
        for (int i = 0; i < swordsmenCount; i++) {
            army.addUnit(new Swordsman());
        }
    }

}
