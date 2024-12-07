package faang.school.godbless.task_44521;

public class Main {

    public static final SpellEvent SPELL_EVENT_1 = new SpellEvent(1, "Защита", "Защищает от атак");
    public static final SpellEvent SPELL_EVENT_2 = new SpellEvent(2, "Чары", "Изменяет цвет предмета");
    public static final SpellEvent SPELL_EVENT_3 = new SpellEvent(3, "Трансфигурация", "Изменяет цвет волос");

    public static final SpellEvent SPELL_EVENT_4 = new SpellEvent(4, "Чары", "Заставляет объект левитировать");
    public static final SpellEvent SPELL_EVENT_5 = new SpellEvent(5, "Трансфигурация", "Делает старше");

    public static final HogwartsSpells HOGWARTS_SPELLS = new HogwartsSpells();

    public static void main(String[] args) {
        HOGWARTS_SPELLS.addSpellEvent(SPELL_EVENT_1.getId(), SPELL_EVENT_1.getEventType(), SPELL_EVENT_1.getAction());
        HOGWARTS_SPELLS.addSpellEvent(SPELL_EVENT_2.getId(), SPELL_EVENT_2.getEventType(), SPELL_EVENT_2.getAction());
        HOGWARTS_SPELLS.addSpellEvent(SPELL_EVENT_3.getId(), SPELL_EVENT_3.getEventType(), SPELL_EVENT_3.getAction());
        HOGWARTS_SPELLS.addSpellEvent(SPELL_EVENT_4.getId(), SPELL_EVENT_4.getEventType(), SPELL_EVENT_4.getAction());
        HOGWARTS_SPELLS.addSpellEvent(SPELL_EVENT_5.getId(), SPELL_EVENT_5.getEventType(), SPELL_EVENT_5.getAction());

        HOGWARTS_SPELLS.printAllSpellEvents();
    }
}
