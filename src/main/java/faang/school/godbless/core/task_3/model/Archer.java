package faang.school.godbless.core.task_3.model;

public class Archer extends Warrior {

    public Archer(String name) {
        super(name);
        super.power = 3;
        super.agility = 10;
        super.intelligence = 5;
    }

    @Override
    public void attack(Character character) {
        System.out.println(name + " атакует с уроном " + agility  + " " + character.name + " с количеством жизней " + character.health);
        character.health -= agility;
        System.out.println("У " + character.name + " осталось " + character.health + " жизней");
    }
}