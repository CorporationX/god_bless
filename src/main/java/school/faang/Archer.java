package school.faang;

public class Archer extends Character {
    public Archer(String name) {
        super(name);
        this.power = 3;
        this.skill = 10;
        this.intellect = 5;
    }

    @Override
    public void attack(Character character) {
        character.health -= this.skill;
    }
}
