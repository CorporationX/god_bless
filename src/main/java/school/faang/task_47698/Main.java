package school.faang.task_47698;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.function.Supplier;

@Slf4j
public class Main {
    private static final Army army = new Army();

    private static final int ARCHERS_COUNT = 20;
    private static final int CAVALRIES_COUNT = 25;
    private static final int MAGES_COUNT = 5;
    private static final int SWORDSMEN_COUNT = 33;

    public static void main(String[] args) {
        initData();
        log.info("army.calculateTotalPower() = {}", army.calculateTotalPower());
    }

    private static void initData() {
        addUnits(ARCHERS_COUNT, Archer::new);
        addUnits(CAVALRIES_COUNT, Cavalry::new);
        addUnits(MAGES_COUNT, Mage::new);
        addUnits(SWORDSMEN_COUNT, Swordsman::new);
    }

    private static void addUnits(int count, @NonNull Supplier<Unit> unitSupplier) {
        if (count < 0) {
            throw new IllegalArgumentException("Count must be positive");
        }
        for (int i = 0; i < count; i++) {
            army.addUnit(unitSupplier.get());
        }
    }

}
