package school.faang;

public class Warrior extends Character {

    public Warrior(String name) {
        super(name,
                GameProperties.Warrior_Strength,
                GameProperties.Warrior_Agility,
                GameProperties.Warrior_Intelligence);
    }

    @Override
    public void attack(Character character) {
        character.setHealth(character.getHealth() - this.getStrength());
    }

}
