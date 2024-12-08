package school.faang.task_43878;

public class Archer extends Character {

    private static final int STRENGTH = 3;
    private static final int DEXTERITY = 10;
    private static final int INTELLIGENCE = 5;

    public Archer(String name) {
        super(name, STRENGTH, DEXTERITY, INTELLIGENCE);
    }

    @Override
    public void attack(Character character) {
        int damage = getDexterity();  // Ловкость используется для расчета урона
        System.out.println(getName() + " attacking " + character.getName() + "\ndamage " + damage);
        character.setHealth(character.getHealth() - damage);
    }
}
