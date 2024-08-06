package faang.school.godbless.Heroes.UI;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
public class Hero{
    @Getter
    private String name;
    private String fraction;
    private int experience;
    private int level;

    @Getter
    private HashMap<String, Creature> army;//ключ - имя моба, значение - объект

    public Hero(String name, String fraction, int experience, int level) {
        this.name = name;
        this.fraction = fraction;
        this.experience = experience;
        this.level = level;
        army = new HashMap<>();
    }

    public void addCreature(Creature creature, int quantity){
        if ( army.containsKey(creature.getName()) ){
            army.get(creature.getName()).
                    setCount(army.get(creature.getName()).getCount() + quantity);
        }else {
            creature.setCount(quantity);
            army.put(creature.getName(), creature);
        }
    }

    public void removeCreature(Creature creature, int quantity){
        if (army.get(creature.getName())!=null){
            army.get(creature.getName()).setCount(
                    army.get(creature.getName()).getCount()-quantity
            );
        }
        if (army.get(creature.getName()).getCount()<=0){
            army.remove(creature.getName());
        }
    }

    public void attack(Hero hero){
        for (Map.Entry<String, Creature> attacker: army.entrySet()){
            for (Map.Entry<String, Creature> defender: hero.army.entrySet()){
                try {
                    attacker.getValue().attack(defender.getValue());
                    defender.getValue().attack(attacker.getValue());
                }catch (IllegalArgumentException e){
                    if (attacker.getValue().getCount() == 0){
                        army.remove(attacker.getKey());
                    }else if (defender.getValue().getCount() == 0){
                        hero.getArmy().remove(defender.getKey());
                    }
                }
            }
        }

    }

}
