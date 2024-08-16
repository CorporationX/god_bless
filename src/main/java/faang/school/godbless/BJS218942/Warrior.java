package faang.school.godbless.BJS218942;

public class Warrior extends Character {
    Warrior(String name) {
        super(name, 10, 5, 3);
    }

    @Override
    public void attack(Character obj) {
        obj.health -= this.power;
        System.out.println(name + "attacks" + obj.name + " for " + power + " damage");
    }
}