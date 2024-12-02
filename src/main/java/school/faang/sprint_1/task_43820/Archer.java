package school.faang.sprint_1.task_43820;

public class Archer extends Character {
    public Archer(String name) {
        super(name);
        power = 3;
        dexterity = 10;
        intelligence = 5;
    }

    public Archer(String name, Integer power, Integer dexterity, Integer intelligence) {
        super(name, power, dexterity, intelligence);
    }

    @Override
    public void attack(Character character) {
        character.setHealth(character.getHealth() - dexterity);
    }
}
