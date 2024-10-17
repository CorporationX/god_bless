package Army;

public class PowerCalculator extends Thread {
    private final Warrior warrior;
    private int result;

    public PowerCalculator(Warrior warrior) {
        this.warrior = warrior;
    }

    @Override
    public void run() {
        result = warrior.getPower();
    }

    public int getResult() {
        return result;
    }
}

