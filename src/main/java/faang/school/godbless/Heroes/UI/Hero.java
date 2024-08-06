package faang.school.godbless.Heroes.UI;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Map;

@AllArgsConstructor
public class Hero{
    private String name;
    private String fraction;
    private int experience;
    private int level;

    public void addCreature(Creature creature, int quantity){

    }

    public void removeCreature(Creature creature, int quantity){

    }

    public Map<Creature, Integer> getArmy(){//ключ - существо, значение - кол-во такиз существ


        return null;
    }
}
