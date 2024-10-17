package module_1.module_1_1_JavaCore.school.faang;

public class Archer extends Character {

    public Archer(String name) {
        super(name, 3, 10, 5);
    }

    public Archer(String name, int power, int dexterity, int intelligence) {
        super(name, power, dexterity, intelligence);
    }

    @Override
    public void attack(Character character) {
        character.setHealth(character.getHealth() - this.getDexterity());
    }
}
