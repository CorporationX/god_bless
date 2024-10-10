package school.faang.BJS2_31387;

public class Warrior extends Character {
    public Warrior(String name) {
        super(name);
        this.setSila(10);
        this.setLovkost(5);
        this.setIntellect(3);
    }

    @Override
    public void attack(Character character) {
        character.setZdorovye(character.getZdorovye() - this.getSila());
    }
}
