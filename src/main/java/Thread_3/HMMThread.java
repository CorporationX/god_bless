package Thread_3;

import Thread_3.Units.Unit;

public class HMMThread extends Thread {

    private int sumPower;
    private Unit unit;

    public HMMThread(Unit unit) {
        sumPower = unit.getCount() * unit.getPower();
    }

    public int getSumPower() {
        return sumPower;
    }

}
