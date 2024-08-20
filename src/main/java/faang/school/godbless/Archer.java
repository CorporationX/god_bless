package faang.school.godbless;

public class Archer extends Character {

    public Archer(String name) {
        super(name,3, 10, 5);
    }

    @Override
    public void attack(Character character) {
        character.health -= this.agility;
        System.out.println(this.name + " наносит удар по " + character.name);
        System.out.println("Damage: " + this.agility);
        System.out.println("Осталось HP: " + character.health);
    }
}
