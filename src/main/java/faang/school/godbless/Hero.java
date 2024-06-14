package faang.school.godbless;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Objects;

@Data
public class Hero {
    private final String NAME;
    private final String FRACTION;
    private final int EXPERIENCE;
    private final int LEVEL;
    private Map<Creature,Integer> ARMY;

    public Hero(String NAME, String FRACTION){
        this.NAME = NAME;
        this.FRACTION = FRACTION;
        this.EXPERIENCE = 100;
        this.LEVEL = 1;
        this.ARMY = new HashMap<>();
    }

    public void addCreature(Creature creature , int quantity){
        creature.quantity = quantity;
        ARMY.put(creature, quantity);
    }

    public void removeCreature(Creature creature , int quantity){
        if(ARMY.containsKey(creature)) {
            int countQuantity = ARMY.get(creature);
            if (countQuantity - quantity <= 0){
                ARMY.remove(creature);
            } else {
                ARMY.put(creature, countQuantity - quantity);
            }
        }
    }

    public List<Creature> getArmy() {
        for (Map.Entry<Creature, Integer> entry : ARMY.entrySet()) {
            System.out.println("У " + this.NAME + " находится в армии: " + entry.getKey().name + " в количестве: " + entry.getValue());
        }
        return ARMY.keySet().stream().toList();
    }


    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hero hero = (Hero) o;
        return EXPERIENCE == hero.EXPERIENCE && LEVEL == hero.LEVEL && Objects.equals(NAME, hero.NAME) && Objects.equals(FRACTION, hero.FRACTION) && Objects.equals(ARMY, hero.ARMY);
    }

    @Override
    public int hashCode() {
        return Objects.hash(NAME, FRACTION, EXPERIENCE, LEVEL, ARMY);
    }

    @Override
    public String toString() {
        return "Hero{" +
                "NAME='" + NAME + '\'' +
                ", FRACTION='" + FRACTION + '\'' +
                ", EXPERIENCE=" + EXPERIENCE +
                ", LEVEL=" + LEVEL +
                ", ARMY=" + ARMY +
                '}';
    }

    public String getNAME() {
        return NAME;
    }
}
