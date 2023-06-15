package faang.school.godbless.Abstraction_Abstraction;

public class Warrior extends Character{

    private static final int STRENGTH = 10;
    private static final int DEXTERITY = 5;
    private static final int INTELLIGENCE = 3;

    public Warrior(String name) {
        super(name, STRENGTH, DEXTERITY, INTELLIGENCE);
    }

    @Override
    public void attack(Character character) {
        if (character.getHealth() <= 0) {
            System.out.println("Enemy is dead");
        } else {
            if (getHealth() > 0) {
                character.setHealth(character.getHealth() - STRENGTH);
            } else {
                System.out.println("You can't attack, you are dead!");
            }
        }

    }
}
