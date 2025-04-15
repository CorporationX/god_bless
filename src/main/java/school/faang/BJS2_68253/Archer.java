package school.faang.BJS2_68253;

public class Archer extends Character {

    private static final int AGILITY = 10;
    private static final int INTELLIGENCE = 5;
    private static final int STRENGTH = 3;

    public Archer(String name) {
        super(AGILITY, INTELLIGENCE, STRENGTH, name);
    }

    @Override
    void attack(Character opponent) {
        opponent.setHealth(opponent.getHealth() - getStrength());
        System.out.println(getName() + " attacks " + opponent.getName() + " and deals " +
                getStrength() + " damage ");
    }
}

