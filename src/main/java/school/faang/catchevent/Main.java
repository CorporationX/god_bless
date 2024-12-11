package school.faang.catchevent;

public class Main {
    public static void main(String[] args) {
        HogwartsSpells hogwartsSpells = getHogwartsSpells();

        System.out.println("Список всех заклинании");
        hogwartsSpells.printAllSpellEvents();

        System.out.println("Заклинание с id 1");
        System.out.println(hogwartsSpells.getSpellEventById(1));

        System.out.println("Заклинании типом Проклинать");
        System.out.println(hogwartsSpells.getSpellEventsByType("Проклинать"));

        System.out.println("Удаление заклинании с id 1 из всех списков заклинании");
        hogwartsSpells.deleteSpellEvent(1);

        System.out.println("Получение заклинании типом Проклинать после удаления с id 1 из списка");
        System.out.println(hogwartsSpells.getSpellEventsByType("Проклинать"));

        System.out.println("Получение не существующего заклинания по id и по типу");
        System.out.println(hogwartsSpells.getSpellEventsByType("Джинкс"));
        System.out.println(hogwartsSpells.getSpellEventById(1));

        System.out.println("Список всех заклинании после удаления");
        hogwartsSpells.printAllSpellEvents();
    }

    private static HogwartsSpells getHogwartsSpells() {
        HogwartsSpells hogwartsSpells = new HogwartsSpells();

        hogwartsSpells.addSpellEvent(1, "Проклинать",
                "Avada Kedavra (Проклятие убийства)");
        hogwartsSpells.addSpellEvent(2, "Проклинать",
                "Imperio позволяет заклинателю получить полный контроль над жертвой)");
        hogwartsSpells.addSpellEvent(3, "Исцеления",
                "заклинания исцеления обладают силой исцелять аспекты организмов");
        hogwartsSpells.addSpellEvent(4, "Очарование",
                "Вингардиум Левиоса — это заклинание, которое заставляет предметы левитировать");
        hogwartsSpells.addSpellEvent(5, "Проклинать",
                "Crucio (Проклятие пытки)");
        hogwartsSpells.addSpellEvent(6, "Преображение",
                "анимагом — или иметь возможность менять свою человеческую форму на животную");
        hogwartsSpells.addSpellEvent(7, "Преображение",
                "Нетрансфигурация — это просто акт возвращения субъекта в его изначальную форму");
        return hogwartsSpells;
    }
}
