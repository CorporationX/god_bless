package school.faang.bjs2_85525;

public class Archer extends Character {
    public Archer(String name) {
        super(name, 3, 10, 5);
    }

    @Override
    void attack(Character opponent) {
        int damage = getDexterity();
        opponent.takeDamage(damage);
    }
}