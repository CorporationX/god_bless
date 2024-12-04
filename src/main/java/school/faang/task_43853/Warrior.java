package school.faang.task_43853;

public class Warrior extends Character {

    public Warrior(String name) {
        super(name);
        this.power = 10;
        this.agility = 5;
        this.intellect = 3;
    }

    @Override
    public void attack(Character character) {
        System.out.printf("%s атакует %s и наносит %s урона%n", this.name, character.getName(), this.power);
        character.setHealth(character.getHealth() - power);
    }

}
