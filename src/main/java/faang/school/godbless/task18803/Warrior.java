package faang.school.godbless.task18803;

public class Warrior extends Character {
    public Warrior(String name, Integer power, Integer dexterity, Integer intelligence) {
        super(name);
        this.power = 10;
        this.dexterity = 5;
        this.intelligence = 3;
    }

    @Override
    public void attack(Character character) {
        this.power -= 10;
        character.health -= 10;
    }
}
