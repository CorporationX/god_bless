package school.faang.RPG;

public class Warrior extends school.faang.RPG.Character {

    public static final int WARRIOR_STRENGTH = 10;
    public static final int WARRIOR_AGILITY = 5;
    public static final int WARRIOR_INTELLIGENCE = 3;

    protected Warrior(String name) {
        super(name);
    }

    @Override
    public void attack(Character opponent) {
        System.out.println(getName() + " атакует " + opponent.getName() + " силой = " + WARRIOR_STRENGTH);
        opponent.takeDamage(WARRIOR_STRENGTH);
    }
}