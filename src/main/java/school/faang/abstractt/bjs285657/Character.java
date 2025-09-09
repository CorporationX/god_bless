package school.faang.abstractt.bjs285657;


import jakarta.annotation.Nonnull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import static school.faang.abstractt.bjs285657.StartCharacteristics.START_DEXTERITY;
import static school.faang.abstractt.bjs285657.StartCharacteristics.START_HP;
import static school.faang.abstractt.bjs285657.StartCharacteristics.START_INTELLIGENCE;
import static school.faang.abstractt.bjs285657.StartCharacteristics.START_STRENGHT;


@Getter
@Setter
@ToString
public abstract class Character {
    private String name;
    private int strenght;
    private int dexterity;
    private int intelligence;
    private int health = START_HP;



    @Nonnull public Character(String name) {
        this.name = name;
        this.strenght = START_STRENGHT;
        this.dexterity = START_DEXTERITY;
        this.intelligence = START_INTELLIGENCE;
    }

    @Nonnull public Character(String name, int strenght, int dexterity, int intelligence) {
        this.name = name;
        this.strenght = strenght;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
    }

    abstract void attack(Character opponent);

    abstract int damage();


}
