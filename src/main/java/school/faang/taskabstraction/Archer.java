package school.faang.taskabstraction;

public class Archer extends Character {

    public Archer(String name) {
        super(name);
        this.power = 3;
        this.intelligence = 5;
        this.agility = 10;
    }

    @Override
    public void attack(Character character) {
        System.out.println(this.name + " наносит урон противнику!");
        character.health -= this.agility;
        System.out.println("Уровень здоровья персонажа " + character.name + " = " + character.health);
    }
}
