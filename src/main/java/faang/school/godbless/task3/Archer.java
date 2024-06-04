package faang.school.godbless.task3;


public class Archer extends Character {

    public void getName(String name) {
        this.name = name;
    }

    public Archer(String name) {
        super(3, 10, 5);
    }


    @Override
    public void attack(Character character) {
        int damage = this.dexterity;
        character.health = character.health - damage;
    }


}
