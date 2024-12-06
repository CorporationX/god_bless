package school.faang.task_43908;

public class Warrior extends Character {
    public static final int STRENGTH = 10;
    public static final int DEXTERITY = 5;
    public static final int INTELLIGENCE = 3;

    public Warrior(String name) {
        super(name, STRENGTH, DEXTERITY, INTELLIGENCE);
    }

    @Override
    public void attack(Character character) {
        int damage = strength;
        character.takeDamage(damage);
        System.out.println(this.name + " dealt " + damage + " damage to " + character.getName());
    }

}
