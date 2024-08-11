package faang.school.godbless.task.hashmap.abstraction.abstraction;

public class Warrior extends Character {

    public Warrior(String name) {
        super(name, 10, 5, 3);
    }

    @Override
    public void attack(Character character) {
        if(character != null) {
            character.health -= this.strength;
        }
    }
}
