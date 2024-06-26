package faang.school.godbless.army;

public class PowerThread extends Thread {
    private int power;
    private Warrior warrior;

    public PowerThread(Warrior warrior) {
        this.warrior = warrior;
    }

    @Override
    public void run() {
        power = warrior.getPower();
    }

    public int getPower() {
        return power;
    }
}
