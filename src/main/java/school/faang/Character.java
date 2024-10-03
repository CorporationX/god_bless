package school.faang;

abstract class Character {
    protected String name;
    protected int strength;
    protected int intelligence;
    protected int health;
    protected int agility;

    public Character(String name) {
        this.name = name;
        this.strength = 0;
        this.intelligence = 0;
        this.health = 100;
        this.agility = 0;
    }

    public Character(String name, int strength, int intelligence, int agility) {
        this.name = name;
        this.strength = strength;
        this.intelligence = intelligence;
        this.health = 100;
        this.agility = agility;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public String getName() {
        return name;
    }

    public abstract void attack(Character hostile);
}

class Warrior extends Character {
    public Warrior(String name) {
        super(name, 10, 5, 3);
    }

    @Override
    public void attack(Character hostile) {
        System.out.println(this.name + " обрушивает свою мощь на " + hostile.name + " с силой " + this.strength);
        hostile.setHealth(hostile.getHealth() - this.strength);
        System.out.println(hostile.getName() + " теряет " + this.strength + " здоровья и остается с " + hostile.getHealth() + " здоровья");
    }
}

class Archer extends Character {
    public Archer(String name) {
        super(name, 3, 10, 5);
    }

    @Override
    public void attack(Character hostile) {
        System.out.println(this.name + " стреляет из эльфийского лука в " + hostile.getName() + " с ловкостью " + this.agility);
        hostile.setHealth(hostile.getHealth() - this.agility);
        System.out.println(hostile.getName() + " теряет " + this.strength + " здоровья и остается с " + hostile.getHealth() + " здоровья");
    }
}
