package faang.school.godbless.task18803;

public class Archer extends Character{
    public Archer(String name) {
        super(name);
    }

    public Archer(String name, Integer power, Integer dexterity, Integer intelligence) {
        super(name);
        this.power = 3;
        this.dexterity = 10;
        this.intelligence = 5;
    }

    @Override
    public void attack(Character character) {
        this.dexterity -= 10;
        character.health -= 10;
    }
}
