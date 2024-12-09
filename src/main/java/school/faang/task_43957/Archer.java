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

    @Override
    public void attack(Character character) {
        int damage = this.strength;
        try {
            if (this.health <= 0) {
                throw new IllegalAccessException(super.getName() + " is already dead!");
            } else {
                character.setHealth(character.getHealth() - damage);
                System.out.println(character
                        .getName() + " was struck by an arrow, losing " + damage + " health damage");
            }
        } catch (IllegalAccessException e) {
            System.out.println("Attack failed: " + e.getMessage());
        }
    }
}
