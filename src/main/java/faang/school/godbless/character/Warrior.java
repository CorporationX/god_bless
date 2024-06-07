package faang.school.godbless.character;

public class Warrior extends Character {

    public Warrior(String name) {
        super(name, 10, 5, 3);

    }


    @Override
   public void attack(Character character) {
        character.setHealth(character.getHealth() - this.power);

    }
}
