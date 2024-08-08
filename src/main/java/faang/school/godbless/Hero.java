package faang.school.godbless;

import java.util.*;

public class Hero {
    private String name;
    private String faction;
    private int level;
    public int experience;
    private List<Creature> army;

    public Hero(String name, String faction) {
        this.name = name;
        this.faction = faction;
        this.level = 1;
        this.experience = 0;
        this.army = new ArrayList<>();
    }

    public void addCreature(Creature creature, int quantity) {
        for(Creature c : army){
            if(c.getName().equals(creature.getName())){
                c.addQuantity(quantity);
                return;
            }
        }
        army.add(creature);
    }

    public void removeCreature(Creature creature, int quantity) {
        for(Creature c : army){
            if(c.getName().equals(creature.getName())){
                c.removeQuantity(quantity);
                if(quantity == 0){
                    army.remove(c);
                }
            }
            return;
        }
    }

    public List<Creature> getArmy() {
        return army;
    }

    @Override
    public String toString() {
        return name + " (" + faction + ")";
    }
}
