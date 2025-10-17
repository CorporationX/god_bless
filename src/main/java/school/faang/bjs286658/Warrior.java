package school.faang.bjs286658;

public class Warrior extends Character {

    public Warrior(String name) {
        super(name, 10, 5, 3);
    }

    @Override
    public void attack(Character opponent) {
        System.out.println(getName() + " hit " + opponent.getName()
                + " (damage equals to his power " + getPower() + ")");
        opponent.takeDamage(getPower());
    }
}
