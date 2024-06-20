package faang.school.godbless.distributed_army_of_heroes;

public class Mage extends Creature{

    public Mage(int power) {
        super(power);
    }

    @Override
    public boolean isMage() {
        return true;
    }
}
