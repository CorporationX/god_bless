package faang.school.godbless;

public class Warrior extends Character {
    public Warrior(String name) {
        super(name,10, 5, 3);
    }

    @Override
    public void attack(Character character) {
        character.health -= this.strength;
        System.out.println(this.name + " наносит удар по " + character.name);
        System.out.println("Damage: " + this.strength);
        System.out.println("Осталось HP: " + character.health);
    }

}
