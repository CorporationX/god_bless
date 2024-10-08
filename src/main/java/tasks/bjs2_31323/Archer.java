package tasks.bjs2_31323;

public class Archer extends Character {
    public Archer(String name) {
        super(name, 3, 11, 5);
    }

    @Override
    public void attack(Character character) {
        showAttackInformation(character.getName(), this.getAgility());
        character.takeDamage(this.getAgility());
    }
}