package faang.school.godbless.hash_map.Heroes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
@ToString
@AllArgsConstructor
public class Hero {
    private String name;
    private String fraction;
    private int experience;
    private int level;
    @Getter
    private final List<Creature> army = new ArrayList<>();

    public void addCreature(Creature creature, int quantity) {
        int indexCreature = army.indexOf(creature);
        if (indexCreature >= 0) {
            army.get(indexCreature).setCount(army.get(indexCreature).getCount() + quantity);
        }
        else {
            creature.setCount(quantity);
            army.add(creature);
        }
    }

    public void removeCreature(Creature creature){
        army.remove(creature);
    }
    public boolean isDefeat(){
        return army.isEmpty();
    }
}
