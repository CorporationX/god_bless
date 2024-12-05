package derschrank.task03.bjstwo_43815;

public class Archer extends Character {
    public Archer(String name) {
        super(name, 3, 10, 5);
        type = "Archer";
    }

    @Override
    public void attack(Character character) {
        character.getDamage(this.getDexterity());
    }
}
