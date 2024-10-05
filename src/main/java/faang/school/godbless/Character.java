package faang.school.godbless;

abstract class Character {
    protected String name;
    protected int strength;
    protected int dexterity;
    protected int intelligence;
    protected int health = 100;

    protected Character(String name) {
        this.name = name;
    }

    protected Character(String name, int strength, int dexterity, int intelligence) {
        this.name = name;
        this.strength = strength;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
    }

    protected abstract void attack(Character character);

    public String getName() {
        return name;
    }

    public int getStrength() {
        return strength;
    }

    public int getDexterity() {
        return dexterity;
    }

    public int getHealth() {
        return health;
    }
}

class Warrior extends Character {
    protected Warrior(String name) {
        super(name, 10, 5, 3);
    }

    protected void attack(Character character) {
        character.health -= character.strength;
        System.out.println(getName() + " нанес урон в количестве = " + getStrength());
        System.out.println("Противнику нанесено урона = " + getHealth());
    }
}

class Archer extends Character {
    protected Archer(String name) {
        super(name, 3, 10, 5);
    }

    protected void attack(Character character) {
        character.health -= character.dexterity;
        System.out.println(getName() + " нанес урон в количестве = " + getDexterity());
        System.out.println("Противнику нанесено урона = " + getHealth());
    }
}

class Game {
    public static void main(String[] args) {
        Warrior warrior = new Warrior("Воин");
        Archer archer = new Archer("Лучник");

        warrior.attack(warrior);
        archer.attack(archer);
    }
}

