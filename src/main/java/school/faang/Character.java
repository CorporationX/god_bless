package school.faang;

public abstract class Character {

    protected static final int BASIC_VALUE = 5;
    protected int power;
    protected int agility;
    protected int intelligence;
    protected int health = 100;
    protected String name;


    protected Character(String name) {
        this(name, BASIC_VALUE, BASIC_VALUE, BASIC_VALUE);
    }

    protected Character(String name, int power, int agility, int intelligence) {
        this.name = name;
        this.power = power;
        this.agility = agility;
        this.intelligence = intelligence;
    }

    public void attack(Character opponent) {
    }

    protected boolean isDeath() {
        return health == 0;
    }
}
