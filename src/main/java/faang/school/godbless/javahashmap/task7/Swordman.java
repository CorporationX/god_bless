package faang.school.godbless.javahashmap.task7;

public class Swordman extends Creature {

    public Swordman() {
        super("Swordman", 1, 6 , 3 , 10, 10, 10, 0);
    }

    @Override
    public Integer getDamage() {
        return attack * level * quantity;
    }
}
