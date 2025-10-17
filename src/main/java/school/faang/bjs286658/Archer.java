package school.faang.bjs286658;

public class Archer extends Character {

    public Archer(String name) {
        super(name, 3, 10, 5);
    }

    @Override
    public void attack(Character opponent) {
        System.out.println(getName() + " hit " + opponent.getName()
                + " (damage equals to his agility " + getAgility() + ")");
        opponent.takeDamage(getAgility());
    }
}
