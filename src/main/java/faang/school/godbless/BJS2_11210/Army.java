package faang.school.godbless.BJS2_11210;

import lombok.AllArgsConstructor;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Army {
    private final List<Character> charactersArmy;

    public Army() {
        this.charactersArmy = new ArrayList<>();
    }

    public void addUnit(@NonNull Character character) {
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
