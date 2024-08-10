package faang.school.godbless.BJS2_18834;

public class Archer extends Character {
    public Archer(String name) {
        super(name, 3, 10, 5);
    }

    @Override
    public void attack(Character character) {
        character.health -= this.dexterity;
        System.out.println(this.getName() + " атакует " + character.name + " и наносит " + this.dexterity +
                " урона. Здоровье " + character.name + ": " + character.health);
    }
}