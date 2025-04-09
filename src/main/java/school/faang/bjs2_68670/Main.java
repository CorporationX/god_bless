package school.faang.bjs2_68670;

public class Main {
    public static void main(String[] args) {
        HogwartsSpells hogwartsSpells = new HogwartsSpells();
        hogwartsSpells.addSpellEvent("Заклинание", "Защита от атак");
        hogwartsSpells.addSpellEvent("Заклинание", "Атака молнией");
        hogwartsSpells.addSpellEvent("Заклинание", "Защита от атаки огнём");
        hogwartsSpells.addSpellEvent("Заклинание", "Превращение в лягушку");
        hogwartsSpells.printAllSpellEvents();
        System.out.println("----------------------");
        hogwartsSpells.deleteSpellEvent(3);
        hogwartsSpells.printAllSpellEvents();
    }
}
