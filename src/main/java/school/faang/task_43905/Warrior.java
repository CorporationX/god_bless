package school.faang.task_43905;

public class Warrior extends Character {
    public Warrior(String name) {
        super(name, 10, 5, 3);
    }

    @Override
    public void attack(Character character) {
        int damage = this.strength;
        character.health -= damage;
        System.out.printf("%s атакует %s и наносит %d урона. Здоровье %s: %d%n",
                this.name, character.name, damage, character.name, character.health);
    }
}
