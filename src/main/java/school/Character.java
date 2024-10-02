package school;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public abstract class Character {
    protected String name;
    protected int strength;
    protected int agility;
    protected int intelligence;
    protected int helth = 100;

    public Character(String name) {
        this.name = name;
    }
    abstract void attack(Character character);

    public int getHealth() {
        return helth;
    }


}
