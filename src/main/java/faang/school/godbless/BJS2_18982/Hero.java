package faang.school.godbless.BJS2_18982;

import java.util.HashMap;
import java.util.Map;

public class Hero {
    private String name;
    private String fraction;
    private int experience;
    private int level;
    private Map<Creature, Integer> army = new HashMap<>();

    public Hero(String name, String fraction, int experience, int level) {
        this.name = name;
        this.fraction = fraction;
        this.experience = experience;
        this.level = level;
    }

    public void addCreature(Creature creature, int quantity ) { //quantity здесь - число ОТРЯДОВ, quantity в creature - число воинов в ОТРЯДЕ
        army.put(creature, creature.getQuantity() * quantity); //army.getOrDefault(creature, 0) + quantity
    }

    public void removeCreature(Creature creature, int quantity) { // в quantity указываем сколько ОТРЯДОВ нужно удалить
        int numUnitsDelete = army.get(creature) - (creature.getQuantity() * quantity);
        if (numUnitsDelete > 0) {
            army.put(creature, numUnitsDelete);
        } else {
            throw new IllegalArgumentException("Число отрядов в армии 0 или меньше 0!!!");
        }
    }

    public void getArmy() {
        for (Map.Entry<Creature, Integer> entry : army.entrySet()) {
            System.out.println("В армии сейчас " + entry.getValue() + " " + entry.getKey().getName() + "s");
        }
    }
}
