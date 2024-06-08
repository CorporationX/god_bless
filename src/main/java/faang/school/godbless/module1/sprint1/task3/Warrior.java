package faang.school.godbless.module1.sprint1.task3;


public class Warrior extends Character {


    public Warrior(String name) {
        super(name);
        this.strange = 10;
        this.agile = 5;
        this.intelligence = 3;
    }

    @Override
    public void attack(Character character) {
        character.heals = character.heals - this.strange;
        System.out.println(character.getName() + " " + character.heals);
    }
}
