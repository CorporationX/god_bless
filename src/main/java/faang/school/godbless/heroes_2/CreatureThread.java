package faang.school.godbless.heroes_2;

import lombok.Getter;

@Getter
public class CreatureThread extends Thread {

    private Creature creature;
    private int power;

    public CreatureThread(Creature creature) {
        this.creature = creature;
    }

    @Override
    public void run() {
        power = creature.getPower();
    }
}
