package HeroesOfMightAndMagic;

import lombok.Getter;

public class PowerCalculatorThread extends Thread {
    private final Squad squad;
    @Getter
    private volatile int result;

    public PowerCalculatorThread(Squad squad) {
        this.squad = squad;
    }

    @Override
    public void run() {
        result = squad.calculateSquadPower();
    }

}
