package school.faang.bjs2_85621.Character;

public class Arching extends Character {
    public Arching(String name) {
        super(name, 3, 12, 5);
    }

    @Override
    public void attack(Character opponent) {
        opponent.receiveDamage(getAgility());
    }
}
