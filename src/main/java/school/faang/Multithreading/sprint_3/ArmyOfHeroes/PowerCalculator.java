package school.faang.Multithreading.sprint_3.ArmyOfHeroes;

public class PowerCalculator implements Runnable {
    private final Character character;
    private int power;

    public PowerCalculator(Character character) {
        this.character = character;
    }

    @Override
    public void run() {
        this.power = character.getPower();
    }

    public int getPowerCalculate() {
        return power;
    }
}
