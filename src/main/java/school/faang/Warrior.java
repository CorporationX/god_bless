package school.faang;

public class Warrior extends Character {

    public Warrior(String name) {
        super(name,
                GameProperties.WarriorStrength,
                GameProperties.WarriorAgility,
                GameProperties.WarriorIntelligence);
    }

    @Override
    public void attack(Character character) {
        character.setHealth(character.getHealth() - this.getStrength());
    }

}
