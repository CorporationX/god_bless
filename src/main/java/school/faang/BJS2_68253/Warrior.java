package school.faang.BJS2_68253;

public class Warrior extends Character {

    public static final int AGILITY = 5;
    public static final int INTELLIGENCE = 3;
    public static final int STRENGTH = 10;

    public Warrior(String name) {
        super(AGILITY, INTELLIGENCE, STRENGTH, name);
    }

    @Override
    void attack(Character opponent) {
        opponent.setHealth(opponent.getHealth() - getAgility());
        System.out.println(getName() + " attacks " + opponent.getName() + " and deals " +
                getAgility() + " damage ");
    }
}
