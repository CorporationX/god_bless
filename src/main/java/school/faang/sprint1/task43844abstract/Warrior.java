package school.faang.sprint1.task43844abstract;

public class Warrior extends Character {

    public Warrior(String name) {
        super(name, 10, 3, 5);
    }

    @Override
    public void attack(Character character) {
        if (this.unacceptableDamage(character)) {
            return;
        }
        int damage = this.strength;
        character.health = character.health - damage;
        if (character.health <= 0) {
            System.out.println(character.name + ": убит");

        }
    }
}
