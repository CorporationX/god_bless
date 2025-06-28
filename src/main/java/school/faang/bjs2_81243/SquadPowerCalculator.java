package school.faang.bjs2_81243;

import lombok.Getter;

public class SquadPowerCalculator extends Thread {
    private Squad<? extends Fighter> squad;
    @Getter
    private int squadPower;

    public SquadPowerCalculator(Squad<? extends Fighter> squad) {
        this.squad = squad;
    }

    @Override
    public void run() {
        squadPower = squad.calculateSquadPower();
        System.out.println("Подсчитана сила отряда: " + squadPower + " (" + squad.getSquadName() + ")");
    }
}
