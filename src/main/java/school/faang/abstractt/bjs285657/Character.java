package school.faang.abstractt.bjs285657;

import lombok.NonNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import static school.faang.abstractt.bjs285657.StartCharacteristics.MIN_HP;
import static school.faang.abstractt.bjs285657.StartCharacteristics.START_DEXTERITY;
import static school.faang.abstractt.bjs285657.StartCharacteristics.START_HP;
import static school.faang.abstractt.bjs285657.StartCharacteristics.START_INTELLIGENCE;
import static school.faang.abstractt.bjs285657.StartCharacteristics.START_STRENGTH;

@Getter
@Setter
@ToString
public abstract class Character {
    private final String name;
    private final int strength;
    private final int dexterity;
    private final int intelligence;
    private int health = START_HP;

    public Character(@NonNull  String name) {
        this.name = name;
        this.strength = START_STRENGTH;
        this.dexterity = START_DEXTERITY;
        this.intelligence = START_INTELLIGENCE;
    }

    public Character(@NonNull String name,  int strenght,  int dexterity,  int intelligence) {
        this.name = name;
        this.strength = strenght;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
    }

    protected void attack(Character opponent) {
        int damage = getDamage();

        opponent.setHealth(Math.max(opponent.getHealth() - damage, MIN_HP));

        System.out.printf("Character %s attack Character %s -  received %s damage left %s Health",
                this.getName(), opponent.getName(), damage, opponent.getHealth());
    }

    protected abstract int getDamage();


}
