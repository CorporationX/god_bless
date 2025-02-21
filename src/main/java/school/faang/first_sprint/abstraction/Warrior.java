package school.faang.first_sprint.abstraction;

public class Warrior extends Character {

    public Warrior(String name) {
        super(name, 10, 5, 3);
    }

    @Override
    public void attack(Character opponent) {
        System.out.printf("%s attacks %s with %d damage \n", getName(), opponent.getName(), getStrength());
        dealDamage(opponent, getStrength());
    }
}
