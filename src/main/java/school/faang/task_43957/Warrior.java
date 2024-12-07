package school.faang.task_43957;

public class Warrior extends Character {
    private static final int WARRIOR_STRENGTH = 10;
    private static final int WARRIOR_AGILITY = 5;
    private static final int WARRIOR_INTELLECT = 3;

    public Warrior(String name) {
        super(name);
        this.strength = WARRIOR_STRENGTH;
        this.agility = WARRIOR_AGILITY;
        this.intelligence = WARRIOR_INTELLECT;
    }

    public Warrior(String name, int strength, int agility, int intelligence) {
        super(name, strength, agility, intelligence);
    }

    @Override
    public void attack(Character character) {
        int damage = this.strength;
        try {
            character.setHealth(character.getHealth() - damage);
            System.out.println(this.getName() + " was struck with a sword, losing " + damage + " health");
        } catch (IllegalArgumentException e) {
            System.err.println("Person " + this.getName() + e.getMessage());
        }
    }
}
