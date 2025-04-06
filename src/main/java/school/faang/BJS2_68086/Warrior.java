package school.faang.BJS2_68086;

public class Warrior extends Character {

    public Warrior(String name) {
        super(name);
        strength = 10;
        dexterity = 5;
        intelligence = 3;
    }

    @Override
    public void attack(Character opponent) {
        opponent.health -= this.strength;
        checkIfOpponentIsKilled(opponent);
    }
}
