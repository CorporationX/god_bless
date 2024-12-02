package school.faang.task_43502;

public class Warrior extends Character {

    public Warrior(String name) {
        super(name);
        setStrength(10);
        setAgility(5);
        setIntelligence(3);
    }

    @Override
    public void attack(Character character) {
        character.setHealth(character.getHealth() - getStrength());
        System.out.println(getName() + " атакует " + character.getName());
    }
}
