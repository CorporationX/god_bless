package sword.and.magic;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class Main {
    private static final Squad<Archer> ARCHER_SQUAD =
            new Squad<>(List.of(new Archer(35), new Archer(43)));
    private static final Squad<Mage> MAGE_SQUAD =
            new Squad<>(List.of(new Mage(25), new Mage(77)));
    private static final Squad<Swordsman> SWORDSMANS_SQUAD =
            new Squad<>(List.of(new Swordsman(55), new Swordsman(47)));

    public static void main(String[] args) {
        Army army = new Army(List.of(ARCHER_SQUAD, MAGE_SQUAD, SWORDSMANS_SQUAD));

        int totalPower = army.calculateTotalPower();
        log.info("Total army power is {}", totalPower);
    }
}
