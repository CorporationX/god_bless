package school.faang.abstraction;

public class Warrior extends Character {

    public Warrior(String name, int strength, int agility, int intelligence) {
        super(name, 10, 5, 3);
    }

    @Override
    void attack(Character opponent) {
        opponent.health -= strength;
        if (opponent.isKilling()) {
            System.out.println("the warrior won");
        }
    }
}
