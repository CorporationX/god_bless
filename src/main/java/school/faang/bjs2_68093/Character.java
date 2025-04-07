package school.faang.bjs2_68093;

abstract class Character {
    protected String name;
    protected int strength;
    protected int agility;
    protected int intellect;
    protected int health = 100;

    protected Character(String name) {
        this.name = name;
        this.strength = 5;
        this.agility = 5;
        this.intellect = 5;
    }

    protected Character(String name, int strength, int agility, int intellect) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intellect = intellect;
    }

    abstract void attack(Character opponent);

    protected void reduceHealth(int attackPower) {
        this.health -= attackPower;
        this.health = Math.max(this.health, 0);
    }
}
