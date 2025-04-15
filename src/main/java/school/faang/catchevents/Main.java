package school.faang.catchevents;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        HogwartsSpells hogwartsSpells = new HogwartsSpells();

        hogwartsSpells.addSpellEvent("Огонь", "Атакует огненным шариком");
        hogwartsSpells.addSpellEvent("Защита", "Создает магический щит");
        hogwartsSpells.addSpellEvent("Огонь", "Атакует огненной волной");

        hogwartsSpells.printAllMagicSpells();

        System.out.println(hogwartsSpells.getSpellById(2));

        List<SpellEvent> charmSpells = hogwartsSpells.getSpellDescriptionByName("Огонь");
        for (SpellEvent spell : charmSpells) {
            System.out.println(spell);
        }

        hogwartsSpells.deleteSpell(3);

        hogwartsSpells.printAllMagicSpells();
    }
}
