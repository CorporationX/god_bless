package faang.school.godbless;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;


import java.util.List;
import java.util.Map;


@AllArgsConstructor
@Getter
@EqualsAndHashCode
@ToString
public class Hero {
    private String name;
    private String faction;
    private int experience;
    private int level;
    private Map<Creature, Integer> army;



    void addCreature(Creature creature, int quantity){
        this.army.put(creature, quantity);
    }
    void removeCreature(Creature creature, int quantity){
        this.army.remove(creature);
    }

}
