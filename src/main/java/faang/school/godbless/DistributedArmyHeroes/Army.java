package faang.school.godbless.DistributedArmyHeroes;

import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

public class Army {
    private final List<Character> charactersArmy;

    public Army() {
        this.charactersArmy = new ArrayList<>();
    }

    public void addCharacter(@NonNull Character character) {
        charactersArmy.add(character);
    }

    public int calculateTotalPower() throws InterruptedException {
        List<ArmyThread> armyThreads = new ArrayList<>();
        for (Character character : charactersArmy) {
            ArmyThread armyThread = new ArmyThread(character);
            armyThreads.add(armyThread);
            armyThread.start();

        }
        return sumPower(armyThreads);
    }

    private int sumPower(List<ArmyThread> armyThreads) throws InterruptedException {
        int sum = 0;
        for (ArmyThread army : armyThreads) {
            army.join(1000);
            sum += army.getPowerCharacter();
        }
        return sum;
    }
}
