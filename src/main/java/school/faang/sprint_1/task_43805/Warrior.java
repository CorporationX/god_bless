package school.faang.sprint_1.task_43805;

public class Warrior extends Character {

    public Warrior(String name) {
        super(name);
        this.power = 10;
        this.dexterity = 5;
        this.intelligence = 3;
    }

    @Override
    public void attack(Character character) {
        character.damage(this.power);
        System.out.println(this.name + " attacks " + character.name);
    }
}

