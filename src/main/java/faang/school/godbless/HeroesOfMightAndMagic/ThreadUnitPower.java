package faang.school.godbless.HeroesOfMightAndMagic;

public class ThreadUnitPower extends Thread {
    private Unit unit;
    private int power;

    public ThreadUnitPower(Unit unit) {
        this.unit = unit;
    }

    public int getPower() {
        return power;
    }

    @Override
    public void run() {
        power = unit.getPowerSquad();
    }
}
