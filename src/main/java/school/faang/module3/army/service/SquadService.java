package school.faang.module3.army.service;

import school.faang.module3.army.entity.Squad;

public class SquadService extends Thread implements Runnable {
    private int squadPower;
    private boolean calculated;
    private final Squad squad;

    public SquadService(Squad squad) {
        this.squad = squad;
    }

    @Override
    public void run() {
        calculated = false;
        squadPower = squad.calculateSquadPower();
        calculated = true;
    }

    public int getSquadPower() {
        if (!calculated) {
            throw new IllegalStateException("total power of squad is not calculated");
        }

        return this.squadPower;
    }
}
