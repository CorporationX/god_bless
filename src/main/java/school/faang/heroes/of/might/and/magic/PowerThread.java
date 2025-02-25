package school.faang.heroes.of.might.and.magic;

import lombok.Getter;

public class PowerThread extends Thread {
    private final Squad squad;
    @Getter
    private int power;

    public PowerThread(Squad squad) {
        this.squad = squad;
    }

    @Override
    public void run() {
        power = squad.calculateSquadPower();
    }
}