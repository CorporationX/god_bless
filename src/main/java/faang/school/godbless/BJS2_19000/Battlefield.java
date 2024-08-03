package faang.school.godbless.BJS2_19000;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class Battlefield {
    private Hero hero1;
    private Hero hero2;

    public Battlefield(Hero hero1, Hero hero2) {
        this.hero1 = hero1;
        this.hero2 = hero2;
    }

    public Hero battle() {
        // Вычисляем общий урон, который могут нанести армии каждого героя
        int hero1TotalDamage = calculateTotalDamage(hero1);
        int hero2TotalDamage = calculateTotalDamage(hero2);

        // Применяем урон к армиям каждого героя
        applyDamage(hero1, hero2TotalDamage);
        applyDamage(hero2, hero1TotalDamage);

        // Подсчитываем оставшиеся единицы у каждого героя после применения урона
        int hero1RemainingUnits = countRemainingUnits(hero1);
        int hero2RemainingUnits = countRemainingUnits(hero2);

        // Сравниваем оставшиеся единицы и определяем победителя
        if (hero1RemainingUnits > hero2RemainingUnits) {
            // Если у героя 1 осталось больше единиц, чем у героя 2, очищаем армию героя 2
            hero2.getArmy().clear();
            return hero1;
        } else if (hero2RemainingUnits > hero1RemainingUnits) {
            // Если у героя 2 осталось больше единиц, чем у героя 1, очищаем армию героя 1
            hero1.getArmy().clear();
            return hero2;
        } else {
            // Если количество оставшихся единиц у обоих героев одинаково, возвращаем ничью
            return null;
        }
    }

    // Метод для вычисления общего урона, который может нанести армия героя
    private int calculateTotalDamage(Hero hero) {
        // Создаем переменную для хранения общего урона
        int totalDamage = 0;
        // Проходим по всем существам в армии героя
        for (Creature creature : hero.getArmy().keySet()) {
            // Суммируем урон, наносимый каждым существом
            totalDamage += creature.getDamage();
        }
        // Возвращаем общий урон
        return totalDamage;
    }

    // Метод для применения урона к армии героя
    private void applyDamage(Hero hero, int totalDamage) {
        // Списки для хранения существ, которые будут удалены или изменены
        List<Creature> toRemove = new ArrayList<>();
        Map<Creature, Integer> toUpdate = new HashMap<>();

        // Проходим по всем существам в армии героя
        for (Creature creature : hero.getArmy().keySet()) {
            // Вычисляем общую защиту существ данного типа
            int creatureDefense = creature.getDefense() * creature.getQuantity();
            // Вычисляем оставшийся урон после вычитания защиты
            int remainingDamage = totalDamage - creatureDefense;
            // Вычисляем количество потерянных единиц
            int lostUnits = Math.max(0, remainingDamage / creature.getDefense());

            // Если количество потерянных единиц больше или равно количеству существ данного типа, добавляем существо в список для удаления
            if (lostUnits >= creature.getQuantity()) {
                toRemove.add(creature);
            } else {
                // В противном случае добавляем существо в список для обновления с количеством потерянных единиц
                toUpdate.put(creature, lostUnits);
            }
            // Обновляем оставшийся урон
            totalDamage = Math.max(0, remainingDamage);
            // Если оставшийся урон равен 0, выходим из цикла
            if (totalDamage == 0) {
                break;
            }
        }

        // Удаляем все существа, которые были добавлены в список для удаления
        for (Creature creature : toRemove) {
            hero.removeCreature(creature, creature.getQuantity());
        }

        // Обновляем количество существ для всех существ, которые были добавлены в список для обновления
        for (Map.Entry<Creature, Integer> entry : toUpdate.entrySet()) {
            hero.removeCreature(entry.getKey(), entry.getValue());
        }
    }

    // Метод для подсчета общего количества оставшихся единиц в армии героя
    private int countRemainingUnits(Hero hero) {
        // Создаем переменную для хранения общего количества оставшихся единиц
        int totalUnits = 0;
        // Проходим по всем существам в армии героя
        for (Creature creature : hero.getArmy().keySet()) {
            // Суммируем количество существ
            totalUnits += creature.getQuantity();
        }
        // Возвращаем общее количество оставшихся единиц
        return totalUnits;
    }

    public static void main(String[] args) {
        Hero hero1 = new Hero("Артур", "Замок");
        Hero hero2 = new Hero("Ланцелот", "Оплот");

        hero1.addCreature(new Pikeman(50), 50);
        hero1.addCreature(new Griffin(30), 30);
        hero1.addCreature(new Swordman(20), 20);


        hero2.addCreature(new Pikeman(60), 60);
        hero2.addCreature(new Griffin(25), 25);
        hero2.addCreature(new Angel(10), 10);

        System.out.println("До битвы:");
        System.out.println(hero1);
        System.out.println(hero2);

        Battlefield battlefield = new Battlefield(hero1, hero2);
        battlefield.battle();

        System.out.println("После битвы:");
        System.out.println(hero1);
        System.out.println(hero2);
    }
}
