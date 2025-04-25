package school.faang.rpg;

import lombok.Getter;

@Getter
public class SquadPowerCalculator extends Thread {
    private final Squad squad;
    private int power;

    public SquadPowerCalculator(Squad squad) {
        this.squad = squad;
    }

    public void run() {
        power = squad.calculateSquadPower();
        System.out.printf("Сила отряда '%s': %d%n", squad.getName(), power);
    }


}
