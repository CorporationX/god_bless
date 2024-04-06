package faang.school.godbless.BJS2_4582;

public class Warrior extends Character {

    public Warrior(String name) {
        super(name, 10, 10, 3);
    }

    public void attack(Character character) {
        character.setHealth(character.getHealth() - this.getForce());
    }
}
