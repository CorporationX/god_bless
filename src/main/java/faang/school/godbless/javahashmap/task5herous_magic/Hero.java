package faang.school.godbless.javahashmap.task5herous_magic;

import lombok.Data;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Data
public class Hero {
    private  String name;
    private  String fraction;
    private int experience;
    private int level;
    private List<Creature> army = new ArrayList<>();

    public Hero(String name, String fraction, int experience, int level) {
        this.name = name;
        this.fraction = fraction;
        this.experience = experience;
        this.level = level;
    }

    public void addCreature(Creature creature, int quantity) {
        if (quantity <= 0) throw new IllegalStateException("Количество должно быть больше нуля");

        if (creature.getQuantity() == 0) {
            creature.setQuantity(quantity);
        } else {
            creature.setQuantity(creature.getQuantity() + quantity);
        }

        army.add(creature);
        System.out.println("Добавлено " + creature.getQuantity() + " воинов " + creature.getName() + " в армию героя " + name);
    }

    public int ripCreature(Creature creature, int quantity) {
        if (quantity <= 0) throw new IllegalStateException("Количество должно быть больше нуля");

        if (creature.getQuantity() - quantity < 0) {
            creature.setQuantity(0);
        } else {
            creature.setQuantity(creature.getQuantity() - quantity);
        }

        if (creature.getQuantity() ==0) {
            getArmy().remove(creature);
        }

        return quantity - creature.getQuantity();
    }

    // проблему удаления смог решить только таким метод, без итератора выдавал ConcurrentModificationException
    public void removeCreatures() {
        Iterator<Creature> iterator = army.iterator();
        while (iterator.hasNext()) {
            Creature creature = iterator.next();
            if (creature.getQuantity() == 0) {
                iterator.remove();
                System.out.println("Уничтожен отряд " + creature.getName());
            }
        }
    }
    public void attack(Hero hero) {
        int sumDamage = 0; // Общий урон который может нанести армия
        int quantityDamage = 0; // Количество определенных воинов, которых может убить общий урон, разное для каждого класса войск

        for (Creature creature: army) {
            sumDamage += creature.getDamage() * creature.getQuantity();
        }

        for (Creature creature: hero.getArmy()) {
            quantityDamage = sumDamage/creature.getHp();
            int ostatok = ripCreature(creature, quantityDamage);

            if (ostatok > 0) {
                sumDamage = ostatok * creature.getHp();  // ковертируем обратно в общий урон, теперь он стал меньше, в следующей итерации quntityDamage определится для другого класса войск;
            } else return;
        }

        hero.removeCreatures();

        if (hero.getArmy().isEmpty()) {
            System.out.println("герой " + name + " ПОБЕДИЛ!!!\n");
        }

    }

}
