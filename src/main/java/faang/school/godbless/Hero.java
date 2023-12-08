package faang.school.godbless;

import java.util.ArrayList;
import java.util.List;

public class Hero {

    private String Name;

    private String Faction;

    private Long Experience;

    private Long Level;
    private List<Creature> creatureList = new ArrayList<>();

    public Hero(String name, String faction, Long experience, Long level) {
        Name = name;
        Faction = faction;
        Experience = experience;
        Level = level;
    }

    public void addCreature(Creature creature, int quantity){
        for(int i = 0; i<quantity;i++ ) {
            creatureList.add(creature);
        }
    }

    public void removeCreature(Creature creature, int quantity){
        for(int i = 0; i<quantity;i++) {
            creatureList.remove(creature);
        }
    }

    public List<Creature> getArmy(){
    return creatureList;
    }

}
