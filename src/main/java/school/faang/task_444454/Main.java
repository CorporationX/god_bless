package school.faang.task_444454;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        final Random random = new Random();
        var hogwartsSpell = new HogwartsSpell(initSpellById(), initSpellsByType());

        SpellEvent spellEventById = hogwartsSpell.getSpellEventById(1);
        System.out.println("Get spell: " + spellEventById);
        System.out.println();

        List<SpellEvent> spellEventsByType = hogwartsSpell.getSpellEventsByType("Чар");
        System.out.println("Get spells: " + spellEventsByType);
        System.out.println();

        hogwartsSpell.addSpellEvent(random.nextInt(1000000), "Чар", "Накладывает чары воздухом");
        System.out.println("Map spell by id: " + hogwartsSpell.getSpellById());
        System.out.println("Map spells by type: " + hogwartsSpell.getSpellsByType());
        System.out.println();

        hogwartsSpell.deleteSpellEvent(6);
        System.out.println("Map spell by id: " + hogwartsSpell.getSpellById());
        System.out.println("Map spells by type: " + hogwartsSpell.getSpellsByType());
        System.out.println();

        hogwartsSpell.printAllSpellEvents();
    }

    private static Map<Integer, SpellEvent> initSpellById() {
        return new HashMap<>() {{
                put(1, new SpellEvent(1, "Чар", "Накладывает чары льдом"));
                put(2, new SpellEvent(2, "Чар", "Накладывает чары огнём"));
                put(3, new SpellEvent(3, "Трансфигурация", "Превращается в кошку"));
                put(4, new SpellEvent(4, "Трансфигурация", "Превращается в собаку"));
                put(5, new SpellEvent(5, "Защита", "Защищает от ближних атак"));
                put(6, new SpellEvent(6, "Защита", "Защищает от дальних атак"));
            }};
    }

    private static Map<String, List<SpellEvent>> initSpellsByType() {
        return new HashMap<>() {{
                put("Чар", new ArrayList<>(
                    Arrays.asList(
                            new SpellEvent(1, "Чар", "Накладывает чары льдом"),
                            new SpellEvent(2, "Чар", "Накладывает чары огнём")
                    )));
                put("Трансфигурация", new ArrayList<>(
                    Arrays.asList(
                            new SpellEvent(3, "Трансфигурация", "Превращается в кошку"),
                            new SpellEvent(4, "Трансфигурация", "Превращается в собаку")
                    )));
                put("Защита", new ArrayList<>(
                    Arrays.asList(
                            new SpellEvent(5, "Защита", "Защищает от ближних атак"),
                            new SpellEvent(6, "Защита", "Защищает от дальних атак")
                    )));
            }};
    }
}
