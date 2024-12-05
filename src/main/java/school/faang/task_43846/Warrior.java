package school.faang.task_43846;


public class Warrior extends Character {

    public Warrior(String name) {
        super(name);
        this.power = 10;
        this.dexterity = 5;
        this.intelligence = 3;
    }

    @Override
    public void attack(Character character) {
        character.setHealth(character.getHealth() - power);

        System.out.println();
        System.out.println(name + " сaused damage " + character.getName() + " on " + power);
    }
}
