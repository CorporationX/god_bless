package school.faang.abstraction_abstraction;

public abstract class Character {
    private String name;
    private int power;
    private int dexterity;
    private int intelligence;
    private int health = 100;

    public Character(String name) {
        this.name = name;
    }

    public Character(String name, int power, int dexterity, int intelligence) {
        this.name = name;
        this.power = power;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
    }

    public abstract void attack(Character opponent);

    public int getHealth() {
        return health;
    }

    public String getName() {
        return name;
    }

    public void takeDamage(int damage){
        health -= damage;
    }
}
