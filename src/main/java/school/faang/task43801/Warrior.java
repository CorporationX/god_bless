package school.faang.task43801;

public class Warrior extends Character {
    private static final int STRENGTH = 10;
    private static final int DEXTERITY = 5;
    private static final int INTELLIGENCE = 3;

    public Warrior(String name) {
        super(INTELLIGENCE, DEXTERITY, STRENGTH, name);
    }

    @Override
    protected void attack(Character otherCharacter) {
        if (!isAlive() || !isAlive(otherCharacter)) {
            return;
        }
        otherCharacter.setHealthPoints(otherCharacter.getHealthPoints() - getStrength());
        if (otherCharacter.getHealthPoints() == LOW_HP) {
            System.out.println(otherCharacter.getName() + " убит");
        }
    }
}
