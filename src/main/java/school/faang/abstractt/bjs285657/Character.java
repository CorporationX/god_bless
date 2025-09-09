package school.faang.abstractt.bjs285657;

import jakarta.annotation.Nonnull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import static school.faang.abstractt.bjs285657.StartCharacteristics.START_DEXTERITY;
import static school.faang.abstractt.bjs285657.StartCharacteristics.START_HP;
import static school.faang.abstractt.bjs285657.StartCharacteristics.START_INTELLIGENCE;
import static school.faang.abstractt.bjs285657.StartCharacteristics.START_STRENGTH;

@Getter
@Setter
@ToString
public abstract class Character {
    private String name;
    private int strength;
    private int dexterity;
    private int intelligence;
    private int health = START_HP;

    public Character(@Nonnull String name) {
        this.name = name;
        this.strength = START_STRENGTH;
        this.dexterity = START_DEXTERITY;
        this.intelligence = START_INTELLIGENCE;
    }

    public Character(@Nonnull String name,  int strenght,  int dexterity,  int intelligence) {
        this.name = name;
        this.strength = strenght;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
    }

    abstract void attack(Character opponent);

    abstract int damage();


}
