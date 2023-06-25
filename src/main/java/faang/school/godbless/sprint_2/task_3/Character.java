package faang.school.godbless.sprint_2.task_3;

public abstract class Character {
    private String name;
    protected int force;
    private int dexterity;
    private int intelligence;
    protected int health = 100;

    public int getHealth() {
        return health;
    }

    public Character(String name) {
        this.name = name;
    }

    public Character(String name, int force, int dexterity, int intelligence) {
        this.name = name;
        this.force = force;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
    }

    public abstract void attack(Character character);
}
