package school.faang.sprint_3.task_bjs247927;

import lombok.experimental.UtilityClass;

import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

@UtilityClass
public class TestDataGenerator {
    private static final Random RANDOM = new Random();

    public List<Unit> createUnits(int count) {
        return IntStream.range(0, count)
                .mapToObj(i -> generateRandomUnit())
                .toList();
    }

    private Unit generateRandomUnit() {
        UnitType type = UnitType.values()[RANDOM.nextInt(UnitType.values().length)];
        int power = RANDOM.nextInt(1, 101);

        return switch (type) {
          case ARCHER -> new Archer(power);
          case MAGE -> new Mage(power);
          case SWORDSMAN -> new Swordsman(power);
        };
    }
}
