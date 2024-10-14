package Army;

public class PowerCalculator extends Thread {
    private final Warrior warrior;
    private int result;

    public PowerCalculator(Warrior warrior) {
        this.warrior = warrior;
    }

    @Override
    public void run() {
        if (warrior instanceof Archer) {
            result = ((Archer) warrior).getPower();
        } else if (warrior instanceof Swordsman) {
            result = ((Swordsman) warrior).getPower();
        } else if (warrior instanceof Mag) {
            result = ((Mag) warrior).getPower();
        }
    }

    public int getResult() {
        return result;
    }
}

