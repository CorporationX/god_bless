package school.faang.sprint_1.task_43849;

public abstract class Character {
    protected String name; // имя
    protected int strength; // сила
    protected int dexterity; // ловкость
    protected int intelligence; // интеллект
    protected int health = 100;

    public Character(String name) {
        this.name = name;
    }

    public Character(String name, int strength, int dexterity, int intelligence) {
        this.name = name;
        this.strength = strength;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
    }

    public abstract void attack(Character character);

    @Override
    public String toString() {
        return String.format("Name: %s, Health: %d", name, health);
    }
}
