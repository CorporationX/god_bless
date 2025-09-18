package school.faang.bjs2_91304;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public class SquadPowerThread extends Thread {
    private final Squad squad;
    private int result;

    public SquadPowerThread(Squad squad) {
        this.squad = squad;
    }

    public void run() {
        result = squad.calculateSquadPower();
    }
}
