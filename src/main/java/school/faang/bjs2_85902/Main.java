package school.faang.bjs2_85902;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        HogwartsSpells hogwartsSpells = new HogwartsSpells();
        try {
            hogwartsSpells.addSpellEvent("Акцио", "Призывает предмет к вам");
            hogwartsSpells.addSpellEvent("Акцио", "Призывает предмет к вам Дважды");
            hogwartsSpells.addSpellEvent("Люмос", "Создает источник света");
            hogwartsSpells.addSpellEvent("Нокс", "Гасит источники света");
            hogwartsSpells.addSpellEvent("Вингардиум Левиоса", "Поднимает предметы в воздух");
            hogwartsSpells.addSpellEvent("Экспеллиармус", "Обезоруживает противника");
            hogwartsSpells.addSpellEvent("Протего", "Создает защитный барьер");
            hogwartsSpells.addSpellEvent("Алохомора", "Открывает замки и двери");
            hogwartsSpells.addSpellEvent("Инсендио", "Создает огонь");
            hogwartsSpells.addSpellEvent("Агуаменти", "Создает воду");
            hogwartsSpells.addSpellEvent("Петрификус Тоталус", "Обездвиживает цель");
            hogwartsSpells.addSpellEvent("Эванеско", "Исчезает предметы");
            hogwartsSpells.addSpellEvent("Круцио", "Заставляет цель испытывать боль");
            hogwartsSpells.addSpellEvent("Империо", "Позволяет контролировать действия цели");
            hogwartsSpells.addSpellEvent("Авада Кедавра", "Смертельное заклинание");
            hogwartsSpells.addSpellEvent("Редукто", "Взрывает предметы");
            hogwartsSpells.addSpellEvent("Конфундус", "Вызывает замешательство у цели");
            hogwartsSpells.printAllSpellEvents();
            hogwartsSpells.deleteSpellEvent(5);
            hogwartsSpells.getSpellEventByType("Акцио");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        hogwartsSpells.getSpellEventById(6);

        List<SpellEvent> listSpell = hogwartsSpells.getSpellEventByType("Длинный прыжок");
        for (SpellEvent list : listSpell) {
            System.out.println(list.toString());
        }
    }
}
