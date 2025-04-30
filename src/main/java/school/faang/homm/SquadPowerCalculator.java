package school.faang.homm;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SquadPowerCalculator extends Thread {
    private Squad squad;
    private int squadPower;

    public SquadPowerCalculator(Squad squad) {
        this.squad = squad;
        this.squadPower = 0;
    }

    public int getSquadPowerResult() {
        return squadPower;
    }

    @Override
    public void run() {
        squadPower = squad.calculateSquadPower();
    }


}
