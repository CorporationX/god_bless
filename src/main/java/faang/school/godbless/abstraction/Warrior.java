package faang.school.godbless.abstraction;

public class Warrior extends Character{
    public Warrior(String name) {
        super(name, 10, 5, 3);
    }

    @Override
    public void Attack(Character character) {
        character.health -= this.strength;
        System.out.println(this.name + " hits " + character.name);
    }
}
