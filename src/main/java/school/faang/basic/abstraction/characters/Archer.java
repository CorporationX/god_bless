package school.faang.basic.abstraction.characters;

public class Archer extends Character{

    public Archer(String name) {
        super(name, 5, 10, 3);
    }

    @Override
    public void attack(Character opponent) {
        opponent.takeDamage(this.agility);
    }
}