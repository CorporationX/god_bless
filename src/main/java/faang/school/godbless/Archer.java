package faang.school.godbless;

public class Archer extends Character{
    public Archer(String name) {
        super(name,3,10,5);
    }

    @Override
    public void attack(Character character) {
        if (character.health > 0) {
            character.health -= dexterity;
        } else {
            System.out.println("Character died");
        }
    }
}
