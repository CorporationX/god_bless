package school.faang.BJS2_68086;

public class Archer extends Character {

    public Archer(String name) {
        super(name);
        strength = 3;
        dexterity = 10;
        intelligence = 5;
    }

    @Override
    public void attack(Character opponent) {
        opponent.health -= this.dexterity;
        checkIfOpponentIsKilled(opponent);
    }
}
