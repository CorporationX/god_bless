package school.faang.module1.abstraction;

import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.experimental.FieldNameConstants;

import static school.faang.module1.abstraction.DefaultCharacteristics.CHARACTER_AGILITY;
import static school.faang.module1.abstraction.DefaultCharacteristics.CHARACTER_INTELLIGENCE;
import static school.faang.module1.abstraction.DefaultCharacteristics.CHARACTER_STRENGTH;
import static school.faang.module1.abstraction.DefaultCharacteristics.INIT_HP;

@ToString
@RequiredArgsConstructor
@FieldNameConstants
public abstract class Character {
    private final String name;
    private final Integer strength;
    private final Integer agility;
    private final Integer intelligence;
    private Integer hitPoints = INIT_HP;

    protected String getName() {
        return name;
    }

    protected Integer getStrength() {
        return strength;
    }

    protected Integer getAgility() {
        return agility;
    }

    protected Integer getIntelligence() {
        return intelligence;
    }

    protected Integer getHitPoints() {
        return hitPoints;
    }

    protected void setHitPoints(Integer hitPoints) {
        this.hitPoints = hitPoints;
    }

    public Character(String name) {
        this.name = name;
        strength = CHARACTER_STRENGTH;
        agility = CHARACTER_AGILITY;
        intelligence = CHARACTER_INTELLIGENCE;
    }

    protected abstract void attack(Character opponent);

    protected abstract int getCharacterDamage();
}
