package faang.school.godbless.heroes;

import java.util.HashMap;
import java.util.Map;
public class Hero {

    private String name;
    private String fraction;
    private int experience;
    private int lvl;

    public int getExperience() {
        return experience;
    }

    public int getLvl() {
        return lvl;
    }

    public Hero(String name, String fraction, int experience, int lvl) {
        this.name = name;
        this.fraction = fraction;
        this.experience = experience;
        this.lvl = lvl;
    }
    private Map<Creature, Integer> army = new HashMap<>();
    public void addCreature(Creature creature, int quantity){
        if (army.containsKey(creature)){
            quantity += army.get(creature);
        }
        army.put(creature, quantity);
    }
    public void removeCreature(Creature creature, int quantity){
        int temp;
        temp = army.get(creature) - quantity;
        if (temp <= 0){
            army.remove(creature);
        }else{
            army.put(creature, temp);
        }
    }
    public Map<Creature, Integer> getArmy(){
        return army;
    }
}
