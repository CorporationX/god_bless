package faang.school.godbless.heroesOfMandM;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Hero {
    String name;
    String fraction;
    int experience;
    int level;
    Map<Creature,Integer> army;

    public Hero(String name) {
        this.name = name;
    }

    void addCreature(Creature creature, int quantity){
        if (army == null){
            army = new HashMap<>();
        }
        if (quantity>0) {
            army.putIfAbsent(creature,0);
            army.put(creature,army.get(creature)+quantity);
        }
    }

    void removeCreature(Creature creature, int quantity){
        if (quantity>0) {
            army.put(creature,army.get(creature)-quantity);
            if (army.get(creature)<=0) {
                army.remove(creature);
            }
        }
    }

    List<Creature> getArmy(){
        List<Creature> armyByItem = new ArrayList<>();
        for (Map.Entry<Creature,Integer> creature : army.entrySet()) {
            for (int i = 0; i < creature.getValue(); i++) {
                armyByItem.add(creature.getKey());
            }
        }
        return armyByItem;
    }

    public String getName() {
        return name;
    }
}
