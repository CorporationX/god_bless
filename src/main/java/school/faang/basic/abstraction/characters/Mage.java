package school.faang.basic.abstraction.characters;

public class Mage extends Character {

    public Mage(String name) {
        super(name, 2, 2, 12);
    }

    @Override
    public void attack(Character opponent) {
        opponent.takeDamage(this.intelligence);
    }
}