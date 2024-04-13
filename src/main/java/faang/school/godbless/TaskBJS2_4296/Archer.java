package faang.school.godbless.TaskBJS2_4296;

public class Archer extends Character {
    private int power = 3;
    private int agility = 10;
    private int intellect = 5;

    public Archer(String name) {
        super(name);
    }

    @Override
    public void attack(Character character) {
        character.health -= this.agility;
        System.out.printf("%s нанес урон %s %n", this.name, character.name);
    }
}
