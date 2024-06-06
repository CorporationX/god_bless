package faang.school.godbless.character;

import lombok.NonNull;

public class Archer extends Character {

    private Integer power = 3;
    private Integer agility = 10;
    private Integer intelligence = 5;

    public Archer(@NonNull String name) {
        super(name);
    }

    public Archer(@NonNull String name, int power, int agility, int intelligence) {
        super(name, power, agility, intelligence);
    }

    @Override
    public void attack(Character character) {
        character.setHealth(character.getHealth() - this.agility);
    }
}
