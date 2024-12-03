package school.faang.task43801;

public class Archer extends Character {
    private static final int STRENGTH = 3;
    private static final int DEXTERITY = 10;
    private static final int INTELLIGENCE = 5;

    public Archer(String name) {
        super(INTELLIGENCE, DEXTERITY, STRENGTH, name);
    }

    @Override
    protected void attack(Character otherCharacter) {
        if (!isAlive() || !isAlive(otherCharacter)) {
            return;
        }
        otherCharacter.setHealthPoints(otherCharacter.getHealthPoints() - getDexterity());
        if (otherCharacter.getHealthPoints() == LOW_HP) {
            System.out.println(otherCharacter.getName() + " убит");
        }
    }
}
