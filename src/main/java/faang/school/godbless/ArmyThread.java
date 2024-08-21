package faang.school.godbless;

import lombok.Getter;

@Getter
public class ArmyThread extends Thread{

    private final Creature creature;
    private int totalPower;

    public ArmyThread(Creature creature) {
        this.creature = creature;
    }

    @Override
    public void run() {
        totalPower = creature.getPower();
    }
}
