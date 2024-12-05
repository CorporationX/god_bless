package school.faang.task_44559;

public class Main {
    public static void main(String[] args) {
        HogwartsSpells hogwartsSpells = new HogwartsSpells();
        hogwartsSpells.addSpellEvent(1, "Чар", "Зажигает свет на кончике палочки");
        hogwartsSpells.addSpellEvent(2, "Трансфигурация", "Преобразует предмет в другой предмет");
        hogwartsSpells.addSpellEvent(3, "Защита", "Создает магический щит от атак");
        hogwartsSpells.addSpellEvent(4, "Чар", "Призывает предмет к колдующему");
        hogwartsSpells.addSpellEvent(5, "Трансфигурация", "Превращает животное в предмет");
        hogwartsSpells.addSpellEvent(6, "Защита", "Нейтрализует заклинания противника");
        hogwartsSpells.addSpellEvent(7, "Чар", "Увеличивает громкость голоса");
        hogwartsSpells.addSpellEvent(8, "Трансфигурация", "Создает копию предмета");
        hogwartsSpells.addSpellEvent(8, "Чар", "Создает животное");

        hogwartsSpells.printAllSpellEvents();

        System.out.println(hogwartsSpells.getSpellEventById(4));

        System.out.println(hogwartsSpells.getSpellsByType("Защита"));

        hogwartsSpells.deleteSpellEvent(8);

        System.out.println(hogwartsSpells.getSpellsByType("Трансфигурация"));

        hogwartsSpells.printAllSpellEvents();

        hogwartsSpells.deleteSpellEvent(8);

    }

}
