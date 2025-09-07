package school.faang.bjs2_85845;

public class Main {
    public static void main(String[] args) {
        HogwartsSpells hogwartsSpells = new HogwartsSpells();
        hogwartsSpells.addSpellEvent("Чары", "Притягивает названный предмет");
        hogwartsSpells.addSpellEvent("Порча", "Вызывает щекотку и ослабляет");
        hogwartsSpells.addSpellEvent("Трансфигурационное", "Создает направленную на цель стрелу");
        hogwartsSpells.addSpellEvent("Чары", "Отпирает замки");
        hogwartsSpells.addSpellEvent("Чары", "Поднимает объект в воздух");
        hogwartsSpells.addSpellEvent("Трансфигурационное", "Связывает");
        hogwartsSpells.printAllSpellEvents();
        System.out.println("-----------------------------------------");
        System.out.println(hogwartsSpells.getSpellEventById(4));
        System.out.println(hogwartsSpells.getSpellEventsByType("Чары"));
        System.out.println("-----------------------------------------");
        hogwartsSpells.deleteSpellEvent(9);
        hogwartsSpells.printAllSpellEvents();
        System.out.println("-----------------------------------------");
        hogwartsSpells.deleteSpellEvent(4);
        hogwartsSpells.printAllSpellEvents();
        System.out.println("-----------------------------------------");
        hogwartsSpells.deleteSpellEvent(2);
        hogwartsSpells.printAllSpellEvents();
    }
}
