package school.faang.sprint_1.task_43820;

public class Archer extends Character {
    public Archer(String name) {
        super(name);
        power = 3;
        dexterity = 10;
        intelligence = 5;
    }

    @Override
    public void attack(Character character) {
        character.setHealth(character.getHealth() - dexterity);
    }
}
