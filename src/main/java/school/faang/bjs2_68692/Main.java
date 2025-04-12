package school.faang.bjs2_68692;

import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        HogwartsSpells hogwartsSpells = new HogwartsSpells();
        hogwartsSpells.addSpellEvent(EventType.TRANSFIGURATION, "Превращение в кошку");
        UUID uuid = hogwartsSpells.addSpellEvent(EventType.MAGIC, "Магия огня");
        UUID uuid2 = hogwartsSpells.addSpellEvent(EventType.PROTECTION, "Защита от физических атак");
        hogwartsSpells.deleteSpellEvent(uuid);
        System.out.println(hogwartsSpells.getSpellEventById(uuid2));
        System.out.println(hogwartsSpells.getSpellEventsByType(EventType.TRANSFIGURATION));
        hogwartsSpells.deleteSpellEvent(uuid);
        hogwartsSpells.printAllSpellEvents();
        System.out.println(hogwartsSpells.getSpellEventById(UUID.randomUUID()));
        hogwartsSpells.deleteSpellEvent(UUID.randomUUID());
        hogwartsSpells.printAllSpellEvents();
    }
}
