package faang.school.godbless.heroes.of.might.and.magic.heros;

import faang.school.godbless.heroes.of.might.and.magic.creatures.Creature;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@NonNull
@Getter
@Setter
@AllArgsConstructor
public class Hero {
    private Map<Creature,Integer> heroArmy = new HashMap<>();
    private String name;
    private String fraction;
    private int experience;
    private int level;

    public void addCreature(Creature creature, int quantity) {
        for()
    }

    public void removeCreature(Creature creature, int quantity) {
    }

    public void getArmy(Creature creature, int quantity) {
    }
}
