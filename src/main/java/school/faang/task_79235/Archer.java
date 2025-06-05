package school.faang.task_79235;

public class Archer extends Character {
    public Archer(String name) {
        super(name, 3, 10, 5);
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
