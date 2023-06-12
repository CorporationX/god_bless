package faang.school.godbless;

public class Archer extends Character {
    public Archer(String name) {
        super(name);
        strength = 3;
        agility = 10;
        intelligence = 5;
    }

    @Override
    public void attack(Character character) {
        System.out.println(this.getClass().getSimpleName() + " атакует " + character.getClass().getSimpleName());
        character.health -= this.agility;
    }
}
