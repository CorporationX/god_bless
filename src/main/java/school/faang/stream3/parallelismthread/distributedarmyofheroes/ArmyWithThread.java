package school.faang.stream3.parallelismthread.distributedarmyofheroes;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
public class ArmyWithThread {
    private List<Squad> armyList = new ArrayList<>();

    public int calculateTotalPower() {
        int totalPower = 0;

        for (Squad squad : armyList) {
            SquadPowerCalculator calculator = new SquadPowerCalculator(squad);
            calculator.run();
            totalPower += calculator.getPower();
        }

        return totalPower;
    }

    public void addSquad(Squad<? extends GameCharacter> squad) {
        armyList.add(squad);
    }

    @RequiredArgsConstructor
    private class SquadPowerCalculator extends Thread {
        private final Squad<? extends GameCharacter> squad;
        @Getter
        private int power;

        @Override
        public void run() {
            power = squad.calculateSquadPower();
        }
    }
}
