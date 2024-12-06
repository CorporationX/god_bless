package school.faang.task_43908;

public class Archer extends Character {
    public static final int STRENGTH = 3;
    public static final int DEXTERITY = 10;
    public static final int INTELLIGENCE = 5;

    public Archer(String name) {
        super(name, STRENGTH, DEXTERITY, INTELLIGENCE);
    }

    @Override
    public void attack(Character character) {
        int damage = dexterity;
        character.takeDamage(damage);
        System.out.println(this.name + " dealt " + damage + " damage to " + character.getName());
    }

}
