package school.faang.bjs2_31447;

public class Warrior extends Character {

    public Warrior(String name) {
        super(name, 10, 5, 3);
    }

    @Override
    void attack(Character character) {
        character.health -= this.strength;
    }


}
