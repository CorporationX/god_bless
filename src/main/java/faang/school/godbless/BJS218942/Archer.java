package faang.school.godbless.BJS218942;

public class Archer extends Character {
    Archer(String name) {
        super(name, 3, 10, 5);
    }

    @Override
    public void attack(Character obj) {
        obj.health -= this.dexterity;
        System.out.println(name + " attacks " + obj.name + " for " + dexterity + " damge");
    }
}
