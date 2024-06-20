package faang.school.godbless.distributed_army_of_heroes;

public class Swordsman extends Creature{

    public Swordsman(int power) {
        super(power);
    }

    @Override
    public boolean isSwordsman() {
        return true;
    }
}
