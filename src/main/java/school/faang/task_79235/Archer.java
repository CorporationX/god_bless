package school.faang.task_79235;

public class Archer extends Character {

    private static final int strengthWarrior = 3;
    private static final int agilityWarrior = 10;
    private static final int intelligenceWarrior = 5;

    public Archer(String name) {
        super(name, strengthWarrior, agilityWarrior, intelligenceWarrior);
    }

    @Override
    public void attack(Character opponent) {
        if (checkOpponentHealth(opponent.getName(), opponent.getHealth(), getAgility())) {
            opponent.setHealth(opponent.getHealth() - getAgility());
            System.out.println(getName() + " наносит " + opponent.getName() + ": " + getAgility() + " единиц урона");
            System.out.println("У " + opponent.getName() + " осталось: " + opponent.getHealth() + " единиц здоровья");
        } else {
            opponent.setHealth(0);
        }
    }
}
