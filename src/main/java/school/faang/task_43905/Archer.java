package school.faang.task_43905;

public class Archer extends Character {
    public Archer(String name) {
        super(name, 3, 10, 5);
    }

    @Override
    public void attack(Character character) {
        int damage = this.dexterity;
        character.health -= damage;
        System.out.printf("%s атакует %s и наносит %d урона. Здоровье %s: %d%n",
                this.name, character.name, damage, character.name, character.health);
    }
}
