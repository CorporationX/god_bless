package faang.school.godbless;

public class Archer extends Character{
    public Archer(String name) {
        super(name, 3, 10, 5);
    }

    @Override
    protected void attack(Character character) {
        if (character.health - this.agility >= 0)
            character.health -= this.agility;
        else
            character.health = 0;
    }
}
