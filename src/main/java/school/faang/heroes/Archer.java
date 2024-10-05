package school.faang.heroes;

public class Archer extends Character {

    public Archer(String name) {
        super(name, 3, 10, 5);
    }

    @Override
    public void attack(Character character) {
        System.out.println(this.getName() + " наносит урон " + character.getName());
        character.takeDamage(this.getAgility());
    }
}