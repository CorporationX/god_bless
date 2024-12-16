package school.faang.heroesofmightandmagic;

import java.util.ArrayList;
import java.util.List;

public class Army {
    List<Character> characters = new ArrayList<>();

    public void addUnit(Character character) {
        characters.add(character);
    }

    public int calculateTotalPower() throws InterruptedException {
        TotalPowerRunner archerTotalPowerRunner = new TotalPowerRunner(
                characters.stream().filter(character -> character.getClass() == Archer.class).toList());
        TotalPowerRunner mageTotalPowerRunner = new TotalPowerRunner(
                characters.stream().filter(character -> character.getClass() == Mage.class).toList());
        TotalPowerRunner swordsmanTotalPowerRunner = new TotalPowerRunner(
                characters.stream().filter(character -> character.getClass() == Swordsman.class).toList());

        Thread archerThread = new Thread(archerTotalPowerRunner);
        Thread mageThread = new Thread(mageTotalPowerRunner);
        Thread swordsmanThread = new Thread(swordsmanTotalPowerRunner);

        archerThread.start();
        mageThread.start();
        swordsmanThread.start();

        archerThread.join();
        mageThread.join();
        swordsmanThread.join();

        return archerTotalPowerRunner.getTotalPower()
                + mageTotalPowerRunner.getTotalPower()
                + swordsmanTotalPowerRunner.getTotalPower();
    }
}
