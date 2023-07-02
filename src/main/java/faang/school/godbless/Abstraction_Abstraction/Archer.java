package faang.school.godbless.Abstraction_Abstraction;

public class Archer extends Character{

    private static final int STRENGTH = 3;
    private static final int DEXTERITY = 10;
    private static final int INTELLIGENCE = 5;

    public Archer(String name) {
        super(name, STRENGTH, DEXTERITY, INTELLIGENCE);
    }

    @Override
    public void attack(Character character) {
        if (character.getHealth() <= 0) {
            System.out.println("Enemy is dead");
        } else {
            if (getHealth() > 0) {
                character.setHealth(character.getHealth() - DEXTERITY);
            } else {
                System.out.println("You can't attack, you are dead!");
            }
        }

    }
}
