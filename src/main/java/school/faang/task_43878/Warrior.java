package school.faang.task_43878;

public class Warrior extends Character {

    private static final int STRENGTH = 10;
    private static final int DEXTERITY = 5;
    private static final int INTELLIGENCE = 3;

    public Warrior(String name) {
        super(name, STRENGTH, DEXTERITY, INTELLIGENCE);
    }

    @Override
    public void attack(Character character) {
        int damage = getStrength();  // Сила используется для расчета урона
        System.out.println(getName() + " атакует " + character.getName() + "\ndamage " + damage);
        character.setHealth(character.getHealth() - damage);
    }
}
