package school.faang.task_79235;

public class Warrior extends Character {

    public Warrior(String name) {
        super(name, 10, 5, 3);
    }

    @Override
    public void attack(Character opponent) {
        if (checkHealth(opponent.getName(), opponent.getHealth(), getStrength())) {
            opponent.setHealth(opponent.getHealth() - getStrength());
            System.out.println(getName() + " наносит " + opponent.getName() + ": " + getStrength() + " единиц урона");
            System.out.println("У " + opponent.getName() + " осталось: " + opponent.getHealth() + " единиц здоровья");
        } else {
            opponent.setHealth(0);
        }
    }
}
