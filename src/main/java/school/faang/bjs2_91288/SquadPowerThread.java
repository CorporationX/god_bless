package school.faang.bjs2_91288;

import lombok.Getter;

public class SquadPowerThread extends Thread {
    private final Squad squad;
    @Getter
    private int power;

    public SquadPowerThread(Squad squad) {
        this.squad = squad;
    }

    @Override
    public void run() {
        power = squad.calculateSquadPower();
    }
}
