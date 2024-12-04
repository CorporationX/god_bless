package school.faang.sprint1.task43844abstract;

public class Warrior extends Character {

    public Warrior(String name) {
        super(name, 10, 3, 5);
    }

    @Override
    public void attack(Character character) {
        if (this.unacceptableDamage(character)){
            return;
        }
        int damadge = this.strength;
        character.health = character.health - damadge;
        if (character.health < 0) {
            System.out.println(character.name + ": убит");

        }
    }


}
