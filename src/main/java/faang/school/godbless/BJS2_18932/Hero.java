package faang.school.godbless.BJS2_18932;

import lombok.Getter;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;

@ToString
public class Hero {
    private String name;
    private String fraction;
    private int exp;
    private int lvl;
    @Getter @ToString.Exclude
    private HashMap<Creature, Integer> army = new HashMap<>();

    public Hero(String name, String fraction, int exp, int lvl) {
        this.name = name;
        this.fraction = fraction;
        this.exp = exp;
        this.lvl = lvl;
    }

    private void checkAddQuantity(int quantity) {
        if (quantity < 1) {
            throw new IllegalArgumentException("quantity не может быть меньше 1");
        }
    }

    public void addCreature(Creature creature, int quantity) {
        checkAddQuantity(quantity);
        army.getOrDefault(creature, 0);
        army.merge(creature, quantity, Integer::sum);
    }

    private void checkRemoveQuantity(Creature creature, int quantity) {
        checkAddQuantity(quantity);
        int quantityInArmy = army.getOrDefault(creature, 0);
        if (quantity > quantityInArmy) {
            throw new IllegalArgumentException("При удалении quantity не может превышать количество выбранных существ в армии");
        }
    }

    public void removeCreature(Creature creature, int quantity) {
        checkRemoveQuantity(creature, quantity);
        army.merge(creature, -quantity, Integer::sum);
    }

    public void viewArmy() {
        for (Map.Entry<Creature, Integer> creature : army.entrySet()) {
            System.out.println(creature.getKey().getName() + " x" + creature.getValue());
        }
    }
}
