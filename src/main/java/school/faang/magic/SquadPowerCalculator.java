package school.faang.magic;

import lombok.Getter;

class SquadPowerCalculator extends Thread {
    private final Squad squad;
    @Getter
    private int squadPower;

    public SquadPowerCalculator(Squad squad) {
        this.squad = squad;
    }

    @Override
    public void run() {
        squadPower = squad.calculateSquadPower();
    }
}