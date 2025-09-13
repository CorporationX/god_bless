package school.faang.bjs2_85621.Character;

public class Warrior extends Character {
    public Warrior(String name) {
        super(name, 110, 5, 3);
    }

    @Override
    public void attack(Character opponent) {
        opponent.receiveDamage(getStrength());
    }
}
