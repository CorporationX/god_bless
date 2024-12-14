package school.faang.sprint1.task_43881;

public class Warrior extends Character {

    public Warrior(String name) {
        super(name);
        this.power = 10;
        this.dexterity = 5;
        this.intellect = 3;
    }

    @Override
    public void attac(Character character) {
        character.health -= this.power;
    }
}
