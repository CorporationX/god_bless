package faang.school.godbless.task.abstraction.abstraction;

public class Archer extends Character{

    public Archer(String name) {
        super(name, 3, 10, 5);
    }

    @Override
    public void attack(Character character) {
        if(character != null) {
            character.health -= this.dexterity;
        }
    }
}
