package school.faang.task_43857;

public class Archer extends Character {
    public Archer(String name) {
        super(name);
        setPower(3);
        setAgility(10);
        setIntellect(5);
    }

    public Archer(String name, int power, int agility, int intellect) {
        super(name, power, agility, intellect);
    }

    @Override
    protected void attack(Character character) {
        character.setHealth(character.getHealth() - this.getAgility());
        System.out.println(character.getHealth());
    }
}
