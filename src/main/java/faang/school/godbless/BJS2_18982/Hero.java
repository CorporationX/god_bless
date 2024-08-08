package faang.school.godbless.BJS2_18982;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Setter
@Getter
public class Hero {
    private String name;
    private String fraction;
    private int experience;
    private int level;
    private Map<Creature, Integer> army = new HashMap<>();

    private int armyHp = 0;
    private int armyAttack = 0;

    public Hero(String name, String fraction, int experience, int level) {
        this.name = name;
        this.fraction = fraction;
        this.experience = experience;
        this.level = level;
    }


    public void addCreature(Creature creature, int quantity ) { //quantity здесь - число ОТРЯДОВ, quantity в creature - число воинов в ОТРЯДЕ
        army.put(creature, creature.getQuantity() * quantity); //army.getOrDefault(creature, 0) + quantity
        armyHp += creature.getHealth() * creature.getQuantity() * quantity;
        armyAttack += creature.getDamage() * creature.getQuantity() * quantity;
    }

    public void removeCreature(Creature creature, int quantity) { // в quantity указываем сколько ОТРЯДОВ нужно удалить
        int numUnitsDelete = army.get(creature) - (creature.getQuantity() * quantity);
        if (numUnitsDelete > 0) {
            army.put(creature, numUnitsDelete);
            armyHp -= creature.getHealth() * creature.getQuantity() * quantity;
            armyAttack -= creature.getDamage() * creature.getQuantity() * quantity;
        } else {
            throw new IllegalArgumentException("Число отрядов в армии 0 или меньше 0!!!");
        }
    }

    public void attack(Hero enemy) {
        enemy.setArmyHp(enemy.getArmyHp() - armyAttack);
        System.out.printf("Армия %s получила %d урона!\n", enemy.getName(), armyAttack);
    }
}
