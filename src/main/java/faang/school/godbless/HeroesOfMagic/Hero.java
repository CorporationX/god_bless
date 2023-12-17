package faang.school.godbless.HeroesOfMagic;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;
@Getter
public class Hero {
    private String name;
    private String faction;
    private int experience; //опыт
    private int level;
    private Map<Creature, Integer> army = new HashMap<>();

    public Hero(String name, String faction, int experience, int level) {
        this.name = name;
        this.faction = faction;
        this.experience = experience;
        this.level = level;
    }


    public void addCreature(Creature creature) {
        if (creature.getQuantity() <= 0) {
            throw new IllegalArgumentException("Количество существ должно быть больше 0");
        }
        if (army.containsKey(creature)) {
            army.put(creature, army.get(creature) + creature.getQuantity());
        }
        army.put(creature, creature.getQuantity());
    }

    public void removeCreature(Creature creature) { //
        if (creature.getQuantity() <= 0) {
            throw new IllegalArgumentException("Количество существ должно быть больше 0");
        } else if (!army.containsKey(creature)) {
            System.out.println("В армии не осталось" + name);
        } else if (army.get(creature) <= creature.getQuantity()) {
            army.remove(creature);
        } else
            army.put(creature, army.get(creature) - creature.getQuantity());
    }

    public void getArmy() {
        System.out.println("В армии " + name);
        for (Map.Entry<Creature, Integer> entry : army.entrySet()) {
            System.out.println(entry);
        }
    }

    public boolean isDefeated() {
        return army.isEmpty();
    }

    public int armyHealth(){
        int armyHealth = 0;
        for (Map.Entry<Creature, Integer> entry : army.entrySet()){
            armyHealth += entry.getKey().health * entry.getValue();
        }
        return armyHealth;
    }

    public int armyAttack(){
        int armyAttack = 0;
        for(Map.Entry<Creature, Integer> entry: army.entrySet()){
            armyAttack = entry.getKey().getDamage() * entry.getValue();
        }
        return armyAttack;
    }
}
