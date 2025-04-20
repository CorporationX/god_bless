package school.faang;

import lombok.Getter;
import school.faang.fighter.Fighter;

public class ThreadPowerCalculator extends Thread {
    private final Squad<? extends Fighter> squad;
    @Getter
    private int squadPower;

    public ThreadPowerCalculator(Squad<? extends Fighter> squad) {
        this.squad = squad;
    }

    @Override
    public void run() {
        squadPower = squad.calculateSquadPower();
        System.out.println("Общая сила отряда: " + squadPower);
    }
}
