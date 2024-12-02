package school.faang.bjs2_43821;

public class Warrior extends Character {

    public Warrior(String name) {
        super(name);
        force = 10;
        agility = 5;
        intellect = 3;
    }

    @Override
    public void attack(Character character) {
        character.setHealth(character.getHealth() - this.force);
    }
}
