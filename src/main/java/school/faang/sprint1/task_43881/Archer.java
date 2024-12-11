package school.faang.sprint1.task_43881;

public class Archer extends Character {

    public Archer(String name) {
        super(name);
        this.power = 3;
        this.dexterity = 10;
        this.intellect = 5;
    }

    @Override
    public void attac(Character character) {
        character.health -= this.dexterity;
    }
}
