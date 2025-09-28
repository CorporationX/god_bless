package bjs2_85359;

public class Main {
    public static void main(String[] args) {
        HogwartsSpells hogwarts = new HogwartsSpells();
        hogwarts.addSpellEvent("Защита", "Создаёт щит");
        hogwarts.addSpellEvent("Защита", "Создаёт бутылку");
        hogwarts.addSpellEvent("Базу", "Атакует базу");
        hogwarts.getSpellEventsByType("Защита");
        hogwarts.deleteSpellEvent(1);
        hogwarts.printAllSpellEvents();

    }
}
