package school.faang.task43801;

public class Archer extends Character {
    private static final int STRENGTH = 3;
    private static final int DEXTERITY = 10;
    private static final int INTELLIGENCE = 5;


    public Archer(String name) {
        super(name);
        this.strength = STRENGTH;
        this.dexterity = DEXTERITY;
        this.intelligence = INTELLIGENCE;
    }

    public Archer(int intelligence, int dexterity, int strength, String name) {
        super(INTELLIGENCE, DEXTERITY, STRENGTH, name);
    }

    @Override
    protected void attack(Character otherCharacter) {
        int currentHp = otherCharacter.getHealthPoints();
        if (isAlive()) {
            otherCharacter.setHealthPoints(currentHp);
            if (isAlive(otherCharacter)) {
                otherCharacter.setHealthPoints(currentHp - getDexterity());
                if (otherCharacter.getHealthPoints() == LOW_HP) {
                    System.out.println(otherCharacter.getName() + " убит");
                }
            }
        }
    }
}
