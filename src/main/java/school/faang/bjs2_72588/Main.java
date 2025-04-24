package school.faang.bjs2_72588;

import java.util.ArrayList;
import java.util.List;
import java.util.random.RandomGenerator;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    private static final RandomGenerator POWER_GENERATOR = RandomGenerator.getDefault();
    private static final int POWER_MIN = 1;
    private static final int POWER_MAX = 100;
    
    public static void main(String[] args) {
        List<Character> archers = new ArrayList<>();
        List<Character> swordsmen = new ArrayList<>();
        List<Character> mages = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Character archer = new Archer("Archer" + i, POWER_GENERATOR.nextInt(POWER_MIN, POWER_MAX));
            Character swordsman = new Swordsman("Swordsman" + i, POWER_GENERATOR.nextInt(POWER_MIN, POWER_MAX));
            Character mage = new Mage("Mage " + i, POWER_GENERATOR.nextInt(POWER_MIN, POWER_MAX));

            archers.add(archer);
            swordsmen.add(swordsman);
            mages.add(mage);
        }

        Squad archersSquad = new Squad(archers);
        Squad swordsmenSquad = new Squad(swordsmen);
        Squad magesSquad = new Squad(mages);

        Army army = new Army(List.of(archersSquad, swordsmenSquad, magesSquad));
        log.info("The total power of the Army is: {}.", army.calculateTotalPower());
    }
}
