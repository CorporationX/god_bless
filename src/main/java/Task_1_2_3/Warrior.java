package Task_1_2_3;

public class Warrior extends Character {

    public Warrior(String name) {
        super(name, 10, 5, 3); // сила 10, ловкость 5, интеллект 3
    }

    @Override
    public void attack(Character opponent) {
        // Наносит урон, равный своей силе
        opponent.takeDamage(this.strength);
    }
}

