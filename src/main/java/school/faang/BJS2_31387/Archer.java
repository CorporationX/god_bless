package school.faang.BJS2_31387;

public class Archer extends Character {
    public Archer(String name) {
        super(name);
        this.setSila(3);
        this.setLovkost(10);
        this.setIntellect(5);
    }

    @Override
    public void attack(Character character) {
        character.setZdorovye(character.getZdorovye() - this.getLovkost());
    }
}
