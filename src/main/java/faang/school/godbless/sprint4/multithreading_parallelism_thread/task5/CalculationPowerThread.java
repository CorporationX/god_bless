package faang.school.godbless.sprint4.multithreading_parallelism_thread.task5;

public class CalculationPowerThread implements Runnable {
    private int power;

    private Character character;

    public CalculationPowerThread(Character character) {
        this.character = character;
    }

    @Override
    public void run() {
        power = character.getPower();
    }

    public int getPower() {
        return power;
    }
}
