package faang.school.godbless;

public class Warrior extends Character{
    public Warrior(String name) {
        super(name,10,5,3);
    }

    @Override
    public void attack(Character character) {
        if (character.health > 0){
            character.health -= force;
        } else {
            System.out.println("Character died");
        }
    }
}
