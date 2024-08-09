package heroOfSwordAndMagic;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
public class Hero {
    private String name;
    private String fraction;
    private int exp;
    private int lvl;

    public void addCreature(Creature creature, int quantity, Map<Creature, Integer> heroArmy) {
        heroArmy.put(creature,quantity);

    }

    public void removeCreature(Creature creature, int quantity, Map<Creature, Integer> heroArmy) {
        if (heroArmy.containsKey(creature)) {
            heroArmy.remove(creature);
        }
    }

    public void getArmy(Map<Creature, Integer> heroArmy) {
        for (Map.Entry<Creature, Integer> pair : heroArmy.entrySet()) {
            System.out.println(pair.getKey() + " : " + pair.getValue());
        }
    }


}
