package school.faang.module1.bjs2_81100;

import lombok.Getter;

@Getter
public class SquadPowerThread extends Thread {

    private final Squad<? extends Warrior> squad;
    private int squadPower;

    public SquadPowerThread(Squad<? extends Warrior> squad) {
        this.squad = squad;
    }

    @Override
    public void run() {
        squadPower = squad.calculateSquadPower();
    }
}