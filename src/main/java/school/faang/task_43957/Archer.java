package school.faang.task_43957;

public class Archer extends Character {
    private static final int ARCHER_STRENGTH = 3;
    private static final int ARCHER_AGILITY = 10;
    private static final int ARCHER_INTELLECT = 5;

    public Archer(String name) {
        super(name);
        this.strength = ARCHER_STRENGTH;
        this.agility = ARCHER_AGILITY;
        this.intelligence = ARCHER_INTELLECT;
    }

    public Archer(String name, int strength, int agility, int intelligence) {
        super(name, strength, agility, intelligence);
    }

    public void attack(Character character) {
        int damage = this.agility;
        String message = character.getName() + " was struck by an arrow, losing " + damage + " health damage";
        super.attack(character, message, damage);
    }
}
