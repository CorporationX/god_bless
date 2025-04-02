package school.faang.distributed_army;

public class SquadPowerCalculator extends Thread {
    private int totalPower;
    private Squad<? extends Hero> squad;

    public SquadPowerCalculator(Squad<? extends Hero> squad) {
        this.squad = squad;
    }

    public int getTotalPower() {
        return this.totalPower;
    }

    @Override
    public void run() {
        totalPower = squad.calculateSquadPower();
    }
}
