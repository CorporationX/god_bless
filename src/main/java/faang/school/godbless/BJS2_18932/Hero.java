package faang.school.godbless.BJS2_18932;

import lombok.Getter;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;

@ToString
public class Hero {
    private String name;
    private String fraction;
    @Getter
    private int exp;
    @Getter
    private int lvl;
    @Getter
    @ToString.Exclude
    private HashMap<Creature, Integer> army = new HashMap<>();

    public Hero(String name, String fraction, int exp, int lvl) {
        this.name = name;
        this.fraction = fraction;
        this.exp = exp;
        this.lvl = lvl;
    }

    private void checkIsGreaterThenOne(int quantity) {
        if (quantity < 1) {
            throw new IllegalArgumentException("quantity cannot be less than 1");
        }
    }

    public void addCreature(Creature creature, int quantity) {
        checkIsGreaterThenOne(quantity);
        army.putIfAbsent(creature, 0);
        army.put(creature, army.get(creature) + quantity);
    }

    private void checkIsValidQuantityToRemove(Creature creature, int quantity) {
        checkIsGreaterThenOne(quantity);
        int quantityInArmy = army.getOrDefault(creature, 0);
        if (quantity > quantityInArmy) {
            throw new IllegalArgumentException("When removed, the quantity cannot exceed the number of selected creatures in the army");
        }
    }

    public void removeCreature(Creature creature, int quantity) {
        checkIsValidQuantityToRemove(creature, quantity);
        army.put(creature, army.get(creature) - quantity);
    }

    public void viewArmy() {
        for (Map.Entry<Creature, Integer> creature : army.entrySet()) {
            System.out.println(creature.getKey().getName() + " x" + creature.getValue());
        }
    }

    public static void main(String[] args) {
        Map<String, Integer> nums = new HashMap<>();
        nums.put("One", 1);
        System.out.println(nums);
    }
}
