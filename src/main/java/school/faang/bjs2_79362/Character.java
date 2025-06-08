package school.faang.bjs2_79362;

import lombok.Getter;

@Getter
public abstract class Character {
    protected String name;
    protected int strength;
    protected int agility;
    protected int intelligence;
    protected int health;

    private static final int DEFAULT_HEALTH = 100;

    public Character(String name) {
        this.name = name;
        this.strength = 5;
        this.agility = 5;
        this.intelligence = 5;
        this.health = DEFAULT_HEALTH;
    }

    public Character(String name, int strength, int agility, int intelligence) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
        this.health = DEFAULT_HEALTH;
    }

    public abstract void attack(Character opponent);

    public void reduceHealth(int damage) {
        if (damage < 0) {
            throw new IllegalArgumentException("Урон не может быть отрицательным!");
        }
        this.health = Math.max(0, this.health - damage);
    }

    public static class Archer extends Character {
        public Archer(String name) {
            super(name);
            this.strength = 3;
            this.agility = 10;
            this.intelligence = 5;
        }

        @Override
        public void attack(Character opponent) {
            System.out.println(name + " атакует " + opponent.getName() +
                    " с силой удара равной ловкости " + agility);
            opponent.reduceHealth(agility);
        }
    }

    public static class Warrior extends Character {
        public Warrior(String name) {
            super(name);
            this.strength = 10;
            this.agility = 5;
            this.intelligence = 3;
        }

        @Override
        public void attack(Character opponent) {
            System.out.println(name + " атакует " + opponent.getName() +
                    " с силой " + strength);
            opponent.reduceHealth(strength);
        }
    }
}