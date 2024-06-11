package abstraction.abstraction;

public abstract class Character {

    private String name;
    private int power;
    private int agility;
    private int intelligence;
    private int health = 100;

    public Character(String name) {
        this.name = name;
    }

    public Character(String name, int power, int agility, int intelligence, int health) {
        this.name = name;
        this.power = power;
        this.agility = agility;
        this.intelligence = intelligence;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public abstract void attack(Character enemy);

    public static class Warrior extends Character {
        public Warrior(String name) {
            super(name, 10, 5, 3, 100);
        }

        @Override
        public void attack(Character enemy) {
            enemy.health -= this.getPower();
        }
    }

    public static class Archer extends Character {
        public Archer(String name) {
            super(name, 3, 10, 5, 100);
        }

        @Override
        public void attack(Character enemy) {
            enemy.health -= this.getAgility();
        }
    }
}
