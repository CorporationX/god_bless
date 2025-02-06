package school.faang.task_56490;

public class Archer extends Character {
    private static final int DEFAULT_STRENGTH = 3;
    private static final int DEFAULT_DEXTERITY = 10;
    private static final int DEFAULT_INTELLIGENCE = 5;

    public Archer(String name) {
        super(name, DEFAULT_STRENGTH, DEFAULT_DEXTERITY, DEFAULT_INTELLIGENCE);
    }

    @Override
    public void attack(Character opponent) {
        System.out.println("Archer " + getName() + " attack: " + opponent.getName()
                + " for " + getDexterity() + " damage");
        reduceHP(opponent, getDexterity());
    }
}
