package school.faang.sprint1.task43844abstract;

public class Archer extends Character {

    public Archer(String name) {
        super(name, 3, 5, 10);
    }

    @Override
    public void attack(Character character) {
        if (this.unacceptableDamage(character)) {
            return;
        }
        int damage = this.dexterity;
        character.health = character.health - damage;
        if (character.health <= 0) {
            System.out.println(character.name + ": убит");

        }
    }
}