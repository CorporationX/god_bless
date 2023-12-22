package faang.school.godbless.BJS2_1120;

public class SumPower extends Thread {
    private final Unit unit;
    private static int archerPower;
    private static int swordsmanPower;
    private static int magePower;

    public SumPower(Unit unit) {
        this.unit = unit;
    }

    public void run() {
        if (unit instanceof Archer) {
            archerPower += unit.getPower();
        } else if (unit instanceof Swordsman) {
            swordsmanPower += unit.getPower();
        } else if (unit instanceof Mage) {
            magePower += unit.getPower();
        }
    }

    public static int getArcherPower() {
        return archerPower;
    }

    public static int getSwordsmanPower() {
        return swordsmanPower;
    }

    public static int getMagePower() {
        return magePower;
    }
}

