package faang.school.godbless.heroes.sprint3;

import faang.school.godbless.heroes.sprint3.creature.Archer;
import faang.school.godbless.heroes.sprint3.creature.Creature;
import faang.school.godbless.heroes.sprint3.creature.Dwarf;
import faang.school.godbless.heroes.sprint3.creature.Goblin;
import faang.school.godbless.heroes.sprint3.creature.Mage;
import faang.school.godbless.heroes.sprint3.creature.Swordsman;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

public class ArmyTest {
    private static final List<Supplier<Creature>> CREATURE_SUPPLIERS = List.of(Archer::new, Dwarf::new, Goblin::new, Mage::new, Swordsman::new);
    private static final int MAX_POWER = 10;
    private static final int MIN_POWER = 1;
    private static final int CREATURES_QUANTITY = 1000_000;

    @Test
    void testCalculateTotalPower() {
        Army army = new Army();
        long totalPower = 0;
        for (int i = 0; i < CREATURES_QUANTITY; i++) {
            Supplier<Creature> creatureSupplier = CREATURE_SUPPLIERS.get(new Random().nextInt(CREATURE_SUPPLIERS.size()));
            int randomPower = new Random().nextInt(MAX_POWER) + MIN_POWER;
            totalPower += randomPower;

            Creature creature = creatureSupplier.get();
            creature.setPower(randomPower);
            army.addUnit(creature);
        }

        Assertions.assertEquals(totalPower, army.calculateTotalPower());
    }
}
