package faang.school.godbless.core.task_3.model;

public class Warrior extends Character {

    public Warrior(String name) {
        super(name);
        super.power = 10;
        super.agility = 5;
        super.intelligence = 3;
    }

    @Override
    public void attack(Character character) {
        System.out.println(name + " атакует с уроном " + power  + " " + character.name + " с количеством жизней " + character.health);
        character.health -= power;
        System.out.println("У " + character.name + " осталось " + character.health + " жизней");
    }
}