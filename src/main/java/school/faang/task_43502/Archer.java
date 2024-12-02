package school.faang.task_43502;

public class Archer extends Character {
    public Archer(String name) {
        super(name);
        setStrength(3);
        setAgility(10);
        setIntelligence(5);
    }

    @Override
    public void attack(Character character) {
        if (checkIsAlive(character)) {
            character.setHealth(character.getHealth() - getAgility());
            System.out.println(getName() + " атакует " + character.getName());
        }
    }
}
