package school.faang;

import java.util.Random;

abstract class Character {
    public String name;
    public int strength;
    public int agility;
    public int intelligence;
    public int health = 100;

    public Character(String name) {
        this.name = name;
        this.strength = 5;
        this.agility = 5;
        this.intelligence = 5;
    }

    public Character(String name, int strength, int agility, int intelligence) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
    }

    public abstract void attack(Character opponent) throws Exception;

    static class Warrior extends Character {

        public Warrior(String name) {
            super(name);
            this.strength = 10;
            this.agility = 5;
            this.intelligence = 3;
        }

        public Warrior(String name, int strength, int agility, int intelligence) {
            super(name, strength, agility, intelligence);
        }

        @Override
        public void attack(Character opponent) throws Exception {
            int damage = this.strength;
            opponent.health -= damage;
        }
    }

    static class Archer extends Character {

        public Archer(String name) {
            super(name);
            this.strength = 3;
            this.agility = 10;
            this.intelligence = 5;
        }

        public Archer(String name, int strength, int agility, int intelligence) {
            super(name, strength, agility, intelligence);
        }

        @Override
        public void attack(Character opponent) throws Exception {
            int damage = this.agility;
            opponent.health -= damage;
        }
    }

    public static void main(String[] args) throws Exception {
        Archer archer = new Archer("Ron");
        Warrior warrior = new Warrior("Hamlet");
        Random random = new Random();
        int randomArcher = random.nextInt(10) +1;
        int randomWarrior = random.nextInt(10) +1;
        for (int i = 0; i < randomArcher; i++) {
            archer.attack(warrior);
            System.out.println(archer.getName() + " deals 10 damage. " + warrior.getName()
                    + "'s health: " + warrior.getHealth());
            if (warrior.getHealth() <= 0) {
                System.out.println(archer.getName() + " wins! " + warrior.getName() + " is dead!");
                break;
            }
        }

        for (int i = 0; i < randomWarrior; i++) {
            warrior.attack(archer);
            System.out.println(warrior.getName() + " deals 10 damage. " + archer.getName()
                    + "'s health: " + archer.getHealth());
            if (archer.getHealth() <= 0) {
                System.out.println(warrior.getName() + " wins! " + archer.getName() + " is dead!");
                break;
            }
        }
    }

    public String getName() {
        return name;
    }

    public int getStrength() {
        return strength;
    }

    public int getAgility() {
        return agility;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public int getHealth() {
        return health;
    }
}
