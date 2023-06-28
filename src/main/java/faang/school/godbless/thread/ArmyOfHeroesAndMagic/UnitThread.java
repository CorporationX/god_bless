package faang.school.godbless.thread.ArmyOfHeroesAndMagic;

public class UnitThread extends Thread {
    private Unit unit;
    private static int sumPower = 0;

    public UnitThread(Unit unit) {
        this.unit = unit;
    }

    @Override
    public void run() {
        sumPower(unit.getPower());
    }

    private static void sumPower(int power) {
        sumPower += power;
    }

    public static int getTotalPower() {
        return sumPower;
    }
}
