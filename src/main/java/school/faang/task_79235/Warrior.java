package school.faang.task_79235;

public class Warrior extends Character {

    private static final int strengthWarrior = 10;
    private static final int agilityWarrior = 5;
    private static final int intelligenceWarrior = 5;

    public Warrior(String name) {
        super(name, strengthWarrior, agilityWarrior, intelligenceWarrior);
    }

    @Override
    public void attack(Character opponent) {
        if (checkOpponentHealth(opponent.getName(), opponent.getHealth(), getStrength())) {
            opponent.setHealth(opponent.getHealth() - getStrength());
            System.out.println(getName() + " наносит " + opponent.getName() + ": " + getStrength() + " единиц урона");
            System.out.println("У " + opponent.getName() + " осталось: " + opponent.getHealth() + " единиц здоровья");
        } else {
            opponent.setHealth(0);
        }
    }
}
