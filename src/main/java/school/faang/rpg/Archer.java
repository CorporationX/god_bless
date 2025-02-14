package school.faang.rpg;

public class Archer extends Character {
    public static final int ARCHER_STRENGTH = 3;
    public static final int ARCHER_AGILITY = 10;
    public static final int ARCHER_INTELLIGENCE = 5;

    protected Archer(String name) {
        super(name);
    }

    @Override
    public void attack(Character opponent) {
        System.out.println(getName() + " атакует " + opponent.getName() + " ловкостью = " + ARCHER_AGILITY);
        opponent.takeDamage(ARCHER_AGILITY);
    }
}