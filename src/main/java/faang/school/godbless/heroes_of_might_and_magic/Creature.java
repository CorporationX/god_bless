package faang.school.godbless.heroes_of_might_and_magic;

abstract public class Creature {
    public String name;
    public int level;
    public int protection;
    public int speed;
    public int quantity;

    abstract public int getDamage();
}
