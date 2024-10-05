package school.faang.heroes;

public class Warrior extends Character {

    public Warrior(String name) {
        super(name, 10, 5, 3);
    }

    @Override
    public void attack(Character character) {
        System.out.println(this.getName() + " наносит урон " + character.getName());
        character.takeDamage(this.getPower());
    }
}