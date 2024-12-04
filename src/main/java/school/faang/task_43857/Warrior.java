package school.faang.task_43857;

public class Warrior extends Character {
    public Warrior(String name) {
        super(name);
        setPower(10);
        setAgility(5);
        setIntellect(3);
    }

    public Warrior(String name, int power, int agility, int intellect) {
        super(name, power, agility, intellect);
    }

    @Override
    protected void attack(Character character) {
        character.setHealth(character.getHealth() - this.getPower());
        System.out.println(character.getHealth());
    }
}
