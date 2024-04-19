package faang.school.godbless.swordandmagic;

import java.util.ArrayList;
import java.util.List;

public class Army {

    private List<Character> characters;
    private List<PowerCalculator> characterThreads = new ArrayList<>();

    public Army(List<Character> characters) {
        this.characters = characters;
    }

    public int calculateTotalPower() throws InterruptedException {
        for (Character character : characters) {
            PowerCalculator powerThread = new PowerCalculator(character);
            characterThreads.add(powerThread);
            powerThread.start();
        }

        int totalPower = getPowerSum(characterThreads);
        return totalPower;
    }

    private int getPowerSum(List<PowerCalculator> characters) throws InterruptedException {
        int totalPower = 0;
        for (PowerCalculator thread : characters) {
            thread.join();
            totalPower += thread.getPower();
        }
        return totalPower;
    }

}
