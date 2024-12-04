package school.faang.task_43853;

public class Archer extends Character {

    public Archer(String name) {
        super(name);
        this.power = 3;
        this.agility = 10;
        this.intellect = 5;
    }

    @Override
    public void attack(Character character) {
        System.out.printf("%s атакует %s и наносит %s урона%n", this.name, character.getName(), this.agility);
        character.setHealth(character.getHealth() - agility);
    }
}
