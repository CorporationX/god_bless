package school.faang.bjs272508;

import lombok.Getter;

@Getter
public class SquadPowerCounter extends Thread {
    private Squad squad;
    private int squadPower;

    public SquadPowerCounter(Squad squad) {
        this.squad = squad;
    }

    @Override
    public void run() {
        squadPower = squad.calculateSquadPower();
    }
}
