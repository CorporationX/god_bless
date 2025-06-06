package school.faang.bjs2_79052;

public class Main {
    public static void main(String[] args) {
        HogwartsSpells.addSpellEvent("Отражение", "Отражает заклинание");
        HogwartsSpells.addSpellEvent("Трансмутация", "Преобразует предметы в лед");
        HogwartsSpells.addSpellEvent("Трансмутация", "Преобразует предметы в огонь");
        HogwartsSpells.addSpellEvent("Чар", "Накладывает отравление на предмет");
        HogwartsSpells.addSpellEvent("Чар", "Закаляет предмет до 100C");
        HogwartsSpells.addSpellEvent("Атака", "Создает сгусток белого света");
        HogwartsSpells.printAllSpellEvents();
        System.out.println(HogwartsSpells.getSpellEventByldId(2));
        System.out.println(HogwartsSpells.getSpellEventsByType("Трансмутация"));
        HogwartsSpells.printAllSpellEvents();
        HogwartsSpells.deleteSpellEvent(0);
        HogwartsSpells.printAllSpellEvents();
    }
}
