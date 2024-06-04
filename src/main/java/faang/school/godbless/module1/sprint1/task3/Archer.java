package faang.school.godbless.module1.sprint1.task3;


public class Archer extends Character {


    public Archer(String name) {
        super(name);
        this.strange = 3;
        this.agile = 10;
        this.intelligence = 5;
    }

    @Override
    public void attack(Character character) {
        character.heals = character.heals - this.agile;
        System.out.println(character.getName() + " " + character.heals);
    }
}
