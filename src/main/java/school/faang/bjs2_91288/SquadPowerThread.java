package school.faang.bjs2_91288;

import lombok.Getter;

public class SquadPowerThread extends Thread {
    private final Squad<? extends Unit> squad;
    @Getter
    private int power;

    public SquadPowerThread(Squad<? extends Unit> squad) {
        this.squad = squad;
    }

    @Override
    public void run() {
        power = squad.calculateSquadPower();
    }
}
