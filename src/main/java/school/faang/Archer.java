package school.faang;

public class Archer extends Character {
    public Archer(String name) {
        super(name, 3, 10, 5);
    }

    @Override
    void attack(Character opponent) {
        opponent.health -= agility;
        if (opponent.minHealth()) {
            System.out.println("the archer won");
        }
    }
}
