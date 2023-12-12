package faang.school.godbless;

public class Warior extends Character {
    public Warior(String name) {
        super(name, 10, 5, 3);
    }

    @Override
    public void attack(Character character) {
        character.setHealth(character.getHealth() - this.power);
    }
}