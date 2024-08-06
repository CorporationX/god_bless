package faang.school.godbless.Mathew;

public class Warior extends Character {
    public Warior(String name) {
        super(name, 10, 5, 3);
    }

    @Override
    public void attack(Character character) {
        character.setHealth(character.getHealth() - getPower());
    }
}
