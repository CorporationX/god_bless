package tasks.bjs2_31323;

public class Warrior extends Character {
    public Warrior(String name) {
        super(name, 10, 5, 3);
    }

    @Override
    public void attack(Character character) {
        showAttackInformation(character.getName(), this.getStrength());
        character.takeDamage(this.getStrength());
    }
}
