package school.faang.task_43876;

public class Archer extends Character {
    public Archer(String name, int power, int agility, int intellect) {
        super(name);
        power = 3;
        agility = 10;
        intellect = 5;
    }

    @Override
    public void attack(Character character) {
        Archer archer = new Archer(name, power, agility, intellect);
        character.setHealth(character.getHealth() - archer.getPower());
    }
}
