package school.faang.task_43885;

import java.util.Objects;

public abstract class Character implements CharacterActions {

    protected int health = 100;
    protected String name;
    protected int strength;
    protected int dexterity;
    protected int intelligence;

    public Character(String name) {
        this.name = name;
    }

    public Character(String name, int strength, int dexterity, int intelligence) {
        this.name = name;
        this.strength = strength;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Character character = (Character) o;
        return Objects.equals(name, character.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

    @Override
    public String toString() {
        return "Character{" + "name='" + name + '\'' + '}';
    }

    public void getLevelAlive() {
        if (this.health <= 0) {
            System.out.println(this.name + " is dead. :( ");
        }
    }

    public abstract void chekHealth();

}

