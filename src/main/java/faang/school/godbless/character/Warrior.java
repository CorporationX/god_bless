package faang.school.godbless.character;

import lombok.NonNull;

public class Warrior extends Character {

    private Integer power = 10;
    private Integer agility = 5;
    private Integer intelligence = 3;

    public Warrior(@NonNull String name) {
        super(name);
    }

    public Warrior(@NonNull String name, int power, int agility, int intelligence) {
        super(name, power, agility, intelligence);
    }

    @Override
    public void attack(Character character) {
        character.setHealth(character.getHealth() - this.getPower());
    }
}
