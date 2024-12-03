package school.faang.sprint_1.task_43831.character;

public abstract class Character {
    protected String name;
    protected Integer strength;
    protected Integer agility;
    protected Integer intelligence;
    protected Integer health = 100;

    public Character(String name, Integer strength, Integer agility, Integer intelligence) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
    }

    public abstract void attack(Character enemy);

    public void takingDamage(int damage) {
        if (damage > health) {
            this.health = 0;
        } else {
            this.health -= damage;
        }
    }
}
