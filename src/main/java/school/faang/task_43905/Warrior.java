package school.faang.task_43905;

public class Warrior extends Character {
    public static final int WARRIOR_STRENGTH = 10;
    public static final int WARRIOR_DEXTERITY = 5;
    public static final int WARRIOR_INTELLIGENCE = 3;

    public Warrior(String name) {
        super(name, WARRIOR_STRENGTH, WARRIOR_DEXTERITY, WARRIOR_INTELLIGENCE);
    }

    @Override
    public void attack(Character character) {
        int damage = this.getStrength();
        applyDamage(character, damage);
    }
}
