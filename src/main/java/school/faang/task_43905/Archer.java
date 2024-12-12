package school.faang.task_43905;

public class Archer extends Character {
    public static final int ARCHER_STRENGTH = 3;
    public static final int ARCHER_DEXTERITY = 105;
    public static final int ARCHER_INTELLIGENCE = 3;

    public Archer(String name) {
        super(name, ARCHER_STRENGTH, ARCHER_DEXTERITY, ARCHER_INTELLIGENCE);
    }

    @Override
    public void attack(Character character) {
        int damage = this.getDexterity();
        applyDamage(character, damage);
    }
}
