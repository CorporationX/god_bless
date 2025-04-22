package school.faang.heroes_of_might_and_magic;

import lombok.Getter;

public class CalculatePower implements Runnable {
    @Getter
    public int totalPower;
    private final Squad squad;

    public CalculatePower(Squad squad) {
        this.squad = squad;
    }

    @Override
    public void run() {
        totalPower = squad.calculateSquadPower();
        System.out.println("Я посчитал: " + squad.units().get(0).getClass());
    }
}
