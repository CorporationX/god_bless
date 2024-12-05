package derschrank.task03.bjstwo_43815;

public class Warrior extends Character {

    public Warrior(String name) {
        super(name, 10, 5, 3);
        type = "Warrior";
    }

    @Override
    public void attack(Character character) {
        character.getDamage(this.getStrength());
    }
}
