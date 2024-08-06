package faang.school.godbless;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class Hero {
    private String name;
    private String fraction;
    private int experience;
    private int level;

    Map<Creature, Integer> army = new HashMap<>();

    public Hero(String name, String fraction, int experience, int level) {
        this.name = name;
        this.fraction = fraction;
        this.experience = experience;
        this.level = level;
    }


    public void addCreatureToArmy(Creature creature, int quantity) {
        if (quantity <= creature.getCount()) {
            army.put(creature, quantity);
            System.out.println("[V] Наняли " + creature.getName() + " в количестве: " + quantity);
        } else {
            System.out.println("[X] Нельзя нанять " + creature.getName() + " больше, чем " + creature.getCount());
        }
    }

//    public void removeCreature(Creature creature, int quantity) {
//        int currentQuantity = army.getOrDefault(creature, 0);
//        if (currentQuantity > quantity) {
//            army.put(creature, currentQuantity - quantity);
//        } else if (currentQuantity > 0 && currentQuantity < quantity) {
//            army.put(creature, 0);
//            army.remove(creature);
//        }
//    }

    public int getAllArmy() {
        System.out.print("[=]Армия " + name + ": ");
        int totalCount = 0;
        for (int count : army.values()) {
            totalCount += count;
        }
        return totalCount;
    }

    public int getAllDamageArmy() {
        int damage = 0;
        for (Map.Entry<Creature, Integer> entry : army.entrySet()) {
            damage += entry.getKey().getDamage() * entry.getValue();
        }
        if (fraction.equals("Warrior")) {
            System.out.println(">>>Опыт " + name + " усиляет армию на " + buffArmy() + " очков атаки!<<<");
            return damage + buffArmy();
        }
        return damage;
    }

    public int getAllArmourArmy() {
        int armour = 0;
        for (Map.Entry<Creature, Integer> entry : army.entrySet()) {
            armour += entry.getKey().getArmour();
        }
        if (fraction.equals("Healer")) {
            System.out.println(">>>Опыт " + name + " усиляет защиту армию на " + buffArmy() + " очков!<<<");
            return armour + buffArmy();
        }
        return armour;
    }

    public int buffArmy() {
        return switch (level) {
            case 1 -> 10;
            case 2 -> 20;
            case 3 -> 30;
            case 4 -> 40;
            case 5 -> 50;
            case 6 -> 60;
            case 7 -> 70;
            default -> 0;
        };
    }

    @Override
    public String toString() {
        return "Fraction= '" + fraction + '\'' +
                ", experience= " + experience +
                ", level= " + level +
                '}';
    }
}
