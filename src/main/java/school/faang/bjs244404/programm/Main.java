package school.faang.bjs244404.programm;

import school.faang.bjs244404.repository.HogwartsSpells;

public class Main {
    public static void main(String[] args) {
        HogwartsSpells hogwartsSpells = new HogwartsSpells();
        hogwartsSpells.addSpellEvent(1, "Защита", "Защищает от атак");
        hogwartsSpells.addSpellEvent(2, "Атака", "Атакует");
        hogwartsSpells.addSpellEvent(3, "Защита", "Защищяет от полёта");
        hogwartsSpells.addSpellEvent(4, "Трансформация", "Трансформирует");
        hogwartsSpells.printAllSpellEvents();
    }
}
