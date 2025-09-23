package school.faang.sprint1.abstraaction;

public class Archer extends Character {

    public Archer(String name) {
        super(name, 3, 10, 5);
    }

    @Override
    public void attack(Character opponent) {
        opponent.applyDamage(this.agility);
    }
}
