package school.faang.hero_buttle;

import lombok.Data;

@Data
public class Superhero {
    private final String name;
    private final int strength;
    private final int agility;

    public Superhero fight(Superhero superhero){
        int sumParam1 = strength + agility;
        int sumParam2 = superhero.strength + superhero.agility;

        return sumParam1 >= sumParam2 ? this : superhero;
    }
}
