package faang.school.godbless.super_heroes_battle;

import lombok.AllArgsConstructor;
import lombok.Getter;
@AllArgsConstructor

@Getter
public class SuperHero {
    private String name;
    private int strength;
    private int agility;

    public int getPower() {
        return this.getAgility() + this.getStrength();
    }
}
