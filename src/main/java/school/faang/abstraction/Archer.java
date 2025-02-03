package school.faang.abstraction;

public class Archer extends Character {

    public Archer(String name) {
        super(name, 3, 10, 5);
    }

    @Override
    public void attack(Character opponent) {
        opponent.setHealth(opponent.getHealth() - getAgility());
    }

    @Override
    public String toString() {
        return String.format("""
                Type: %s
                Name: %s
                Health: %d
                """,
                getClass().getSimpleName(), getName(), getHealth());
    }

}
