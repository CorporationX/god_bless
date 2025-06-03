package school.faang;

public class Warrior extends Character {
    public Warrior(String name) {
        super(name, 10, 5, 3);
    }

    @Override
    void attack(Character opponent) {
        opponent.health -= strength;
        if (opponent.minHealth()) {
            System.out.println("the warrior won");
        }
    }
}
