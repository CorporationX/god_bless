package faang.school.godbless.abstraction;

public class Archer extends Character{
    public Archer(String name) {
        super(name, 3, 10, 5);
    }

    @Override
    public void Attack(Character character) {
        character.health -= this.agility;
        System.out.println(this.name + " hits " + character.name);
    }
}
