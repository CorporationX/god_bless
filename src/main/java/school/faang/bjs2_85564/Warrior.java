package school.faang.bjs2_85564;

public class Warrior extends Character {
    public static final int STRENGTH = 10;
    public static final int AQILITY = 5;
    public static final int INTELLIGENCE = 3;

    public Warrior(String name) {
        super(name, STRENGTH, AQILITY, INTELLIGENCE);
    }

    @Override
    public void attack(Character opponent) {
        if (getHealth() == 0) {
            return;
        }
        System.out.printf("%s атакует %s с силой %d%n", getName(), opponent.getName(), getStrength());
        opponent.takeDamage(getStrength());
    }
}
