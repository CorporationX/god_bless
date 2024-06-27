package faang.school.godbless.distributed_army_of_heroes;

public class CreatureThread extends Thread {

    private final Creature creature;
    private int power;

    public CreatureThread(Creature creature) {
        this.creature = creature;
    }

    @Override
    public void run() {
        power = creature.getPower();
    }

    public int getPower() {
        return power;
    }
}
