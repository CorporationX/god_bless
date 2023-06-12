package faang.school.godbless;

public class Warrior extends Character {
    public Warrior(String name) {
        super(name);
        strength = 10;
        agility = 5;
        intelligence = 3;
    }

    @Override
    public void attack(Character character) {
        System.out.println(this.getClass().getSimpleName() + " атакует " + character.getClass().getSimpleName());
        character.health -= this.strength;
    }
}
