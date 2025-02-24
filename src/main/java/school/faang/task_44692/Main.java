package school.faang.task_44692;

public class Main {
    public static void main(String[] args) {
        SpellEvent spell = new SpellEvent(1, "Чар", "Защищает от атак");
        HogwartsSpells.addSpellEvent(1, "Чар", "Защищает от атак");
        HogwartsSpells.prinAllSpellEvents();

        for (var spellFrom : HogwartsSpells.getSpellEventsByType(spell.getEventType())) {
            System.out.println(spellFrom);
        }

        HogwartsSpells.deleteSpellEvent(1);

        HogwartsSpells.addSpellEvent(3, "Защита", "Преобразует предмет");
        HogwartsSpells.prinAllSpellEvents();

    }
}
