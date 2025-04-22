package school.faang.bjs272508;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

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
