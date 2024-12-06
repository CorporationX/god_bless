package school.faang.task_44559;

import school.faang.task_44559.entity.SpellEvent;
import school.faang.task_44559.entity.SpellType;

public class Main {
    public static void main(String[] args) {
        HogwartsSpells hogwartsSpells = new HogwartsSpells();
        hogwartsSpells.addSpellEvent(new SpellEvent(1, SpellType.CHARM, "Lights up the tip of the wand"));
        hogwartsSpells.addSpellEvent(
                new SpellEvent(2, SpellType.TRANSFIGURATION, "Transforms an object into another object"));
        hogwartsSpells.addSpellEvent(
                new SpellEvent(3, SpellType.PROTECTION, "Creates a magical shield against attacks"));
        hogwartsSpells.addSpellEvent(new SpellEvent(4, SpellType.CHARM, "Summons an item to the caster"));
        hogwartsSpells.addSpellEvent(new SpellEvent(5, SpellType.TRANSFIGURATION, "Turns an animal into an object"));
        hogwartsSpells.addSpellEvent(new SpellEvent(6, SpellType.PROTECTION, "Neutralizes an opponent's spells"));
        hogwartsSpells.addSpellEvent(new SpellEvent(7, SpellType.CHARM, "Increases the volume of the voice"));
        hogwartsSpells.addSpellEvent(new SpellEvent(8, SpellType.TRANSFIGURATION, "Creates a duplicate of an object"));
        hogwartsSpells.addSpellEvent(new SpellEvent(8, SpellType.CHARM, "Creates an animal"));

        hogwartsSpells.printAllSpellEvents();
        System.out.println(hogwartsSpells.getSpellEventById(4));
        System.out.println(hogwartsSpells.getSpellsByType(SpellType.PROTECTION));
        hogwartsSpells.deleteSpellEvent(8);
        System.out.println(hogwartsSpells.getSpellsByType(SpellType.TRANSFIGURATION));
        hogwartsSpells.printAllSpellEvents();
        hogwartsSpells.deleteSpellEvent(8);
    }

}
