package faang.school.godbless.TaskBJS2_4296;


public class Warrior extends Character {
    private int power = 10;
    private int agility = 5;
    private int intellect = 3;

    public Warrior(String name) {

        super(name);
    }

    @Override
    public void attack(Character character) {
        character.health -= this.power;
        System.out.printf("%s нанес урон %s", this.name, character.name);

    }
}
