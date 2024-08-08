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

    public int summaryPower(){//метод для подсчета силы армии
        int sum = 0;
        for (Map.Entry<String, Creature> pair:army.entrySet()){
            sum+=(pair.getValue()).summaryPower()*(pair.getValue()).getCount();
        }
        return sum;
    }

}
