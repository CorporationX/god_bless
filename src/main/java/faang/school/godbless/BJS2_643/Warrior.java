package faang.school.godbless.BJS2_643;

public class Warrior extends Character {

      public Warrior (String name) {
        super(name);
    }

    public Warrior(int power, int dexterity, int intelligence) {
        super(10, 5, 3);
    }

    @Override
    void attack(Character character) {
        character.health = character.health - this.power;
    }
}
