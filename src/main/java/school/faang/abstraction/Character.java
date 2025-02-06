package school.faang.abstraction;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

abstract class Character {
    private String name;
    private int force;
    private int dexterity;
    private int intellect;
    private int health;

    public Character(String name) {
        this.name = name;
        this.force = 5;
        this.dexterity = 5;
        this.intellect = 5;
        this.health = 100;
    }

    public Character(String name, int force, int dexterity, int intellect) {
        this.name = name;
        this.force = force;
        this.dexterity = dexterity;
        this.intellect = intellect;
        this.health = 100;

    }

    public abstract void attack(Character opponent);

    public void decreasedHealth(Character opponent, int damage) {
        int newHealth = opponent.getHealth() - damage;
        opponent.setHealth(Math.max(newHealth, 0));
    }

    static class Warrior extends Character {
        public Warrior(String name) {
            super(name, 10, 5, 3);
        }

        @Override
        public void attack(Character opponent) {
            int damage = getForce();
            decreasedHealth(opponent, damage);
            System.out.println(getName() + " атакует " + opponent.getName() + " и наносит " + damage + " урона!");
        }
    }

    static class Archer extends Character {
        public Archer(String name) {
            super(name, 3, 10, 5);
        }

        @Override
        public void attack(Character opponent) {
            int damage = getDexterity();
            decreasedHealth(opponent, damage);
            System.out.println(getName() + " атакует " + opponent.getName() + " и наносит " + damage + " урона!");

        }
    }

}

