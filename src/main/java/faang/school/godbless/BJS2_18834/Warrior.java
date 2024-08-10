package faang.school.godbless.BJS2_18834;

public class Warrior extends Character {

    public Warrior(String name) {
        super(name, 10, 5, 3);
    }

    @Override
    public void attack(Character character) {
        character.health -= this.power;
        System.out.println(this.getName() + " атакует " + character.name + " и наносит " + this.power +
                " урона. Здоровье " + character.name + ": " + character.health);
    }
}
