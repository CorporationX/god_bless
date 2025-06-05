package school.faang.abstraction;

/**
 * @author Danil Pudovkin
 * @since 05.06.2025
 */
public class Warrior extends Character {

    public Warrior(String name) {
        super(name, 10, 5, 3);
    }

    @Override
    public void attack(Character opponent) {
        opponent.decreaseHealth(this.strength);
    }

    @Override
    public String toString() {
        return "Warrior(name = " + name + ")";
    }
}
