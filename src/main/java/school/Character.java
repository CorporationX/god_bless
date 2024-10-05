package school;


import lombok.Setter;

public abstract class Character {
    protected String name;
    protected int strength;
    protected int agility;
    protected int intelligence;
    @Setter
    private int helth = 100;

    public Character(String name) {
        this(name, 0, 0, 0);
    }

    public Character(String name, int strength, int agility, int intelligence) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
    }

    protected abstract void attack(Character character);

    public int getHealth() {
        return helth;
    }

}
