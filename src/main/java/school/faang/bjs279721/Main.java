package school.faang.bjs279721;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        HogwartsSpells hogwartsSpells = new HogwartsSpells();
        hogwartsSpells.addSpellEvent("Наложение", "Слабый хил");
        hogwartsSpells.addSpellEvent("Наложение", "Средний хил");
        hogwartsSpells.addSpellEvent("Наложение", "Сильный хил");
        hogwartsSpells.addSpellEvent("Наложение", "Усиление");
        hogwartsSpells.addSpellEvent("Атака", "Fire boll");
        hogwartsSpells.addSpellEvent("Зачарование", "Укрепление оружия");

        hogwartsSpells.printAllSpellEvents();

        String findEvenType = hogwartsSpells.getSpellEventById(1);
        try {
            List<String> findEvenActionSpell = hogwartsSpells.getSpellEventsByType(findEvenType);
            System.out.print("У тип заклинания есть такие вариации: ");
            for (String action : findEvenActionSpell) {
                System.out.println(action);
            }
        } catch (Exception e) {
            System.out.println("Дамы и господа у нас ошибка, она звучит так: " + e);
        }
    }
}

