package school.faang.task_43957;

import lombok.Getter;

@Getter
public abstract class Character {
    private static final int MAX_HEALTH = 100;
    private final String name;
    protected int strength;
    protected int agility;
    protected int intelligence;
    protected int health = MAX_HEALTH;

    protected Character(String name) {
        this.name = name;
    }

    protected Character(String name, int strength, int agility, int intelligence) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
    }

    public void attack(Character character, String attackMessage, int damage) {
        try {
            if (this.health <= 0) {
                throw new IllegalAccessException(this.getName() + " is already dead!");
            } else {
                character.setHealth(character.getHealth() - damage);
                System.out.println(attackMessage);
            }
        } catch (IllegalAccessException e) {
            System.out.println("Attack failed: " + e.getMessage());
        }
    }

    protected void setHealth(int health) {
        try {
            if (health >= 1 && health <= MAX_HEALTH) {
                this.health = health;
            } else if (health < 1) {
                this.health = 0;
                throw new IllegalArgumentException(this.name + " is dead");
            } else {
                throw new IllegalArgumentException("Health cannot exceed " + MAX_HEALTH);
            }
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public String toString() {
        return "Character{"
                + "name='" + name + '\''
                + ", strength=" + strength
                + ", agility=" + agility
                + ", intelligence=" + intelligence
                + ", health=" + health
                + '}';
    }
}



