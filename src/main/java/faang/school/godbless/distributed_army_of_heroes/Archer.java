package faang.school.godbless.distributed_army_of_heroes;

public class Archer extends Creature{

    public Archer(int power) {
        super(power);
    }

    @Override
    public boolean isArcher() {
        return true;
    }
}
