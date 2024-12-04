package school.faang.abstractions;

public abstract class Character {
    protected String name;
    protected int strength;
    protected int dexterity;
    protected int intelligence;
    protected int hp;

    public Character(String name) {
        this.name = name;
        hp = 100;
    }

    public Character(String name, int strength, int dexterity, int intelligence) {
        this.name = name;
        this.strength = strength;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
        this.hp = 100;
    }

    public abstract void attack(Character enemy);

    public int getHp() {
        return hp;
    }


}
