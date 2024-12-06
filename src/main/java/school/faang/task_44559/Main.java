package school.faang.task_44559;

import school.faang.task_44559.entity.SpellEvent;
import school.faang.task_44559.entity.SpellType;

public class Main {
    public static void main(String[] args) {
        HogwartsSpells hogwartsSpells = new HogwartsSpells();

        SpellEvent wandLightingSpell = new SpellEvent(1, SpellType.CHARM, "Lights up the tip of the wand");
        SpellEvent objectTransformationSpell = new SpellEvent(2, SpellType.TRANSFIGURATION, "Transforms an object into another object");
        SpellEvent magicalShieldSpell = new SpellEvent(3, SpellType.PROTECTION, "Creates a magical shield against attacks");
        SpellEvent itemSummonSpell = new SpellEvent(4, SpellType.CHARM, "Summons an item to the caster");
        SpellEvent animalToObjectSpell = new SpellEvent(5, SpellType.TRANSFIGURATION, "Turns an animal into an object");
        SpellEvent spellNeutralizationSpell = new SpellEvent(6, SpellType.PROTECTION, "Neutralizes an opponent's spells");
        SpellEvent voiceAmplificationSpell = new SpellEvent(7, SpellType.CHARM, "Increases the volume of the voice");
        SpellEvent objectDuplicationSpell = new SpellEvent(8, SpellType.TRANSFIGURATION, "Creates a duplicate of an object");

        hogwartsSpells.addSpellEvent(wandLightingSpell);
        hogwartsSpells.addSpellEvent(objectTransformationSpell);
        hogwartsSpells.addSpellEvent(magicalShieldSpell);
        hogwartsSpells.addSpellEvent(itemSummonSpell);
        hogwartsSpells.addSpellEvent(animalToObjectSpell);
        hogwartsSpells.addSpellEvent(spellNeutralizationSpell);
        hogwartsSpells.addSpellEvent(voiceAmplificationSpell);
        hogwartsSpells.addSpellEvent(objectDuplicationSpell);

        hogwartsSpells.printAllSpellEvents();
        System.out.println(hogwartsSpells.getSpellEventById(4));
        System.out.println(hogwartsSpells.getSpellsByType(SpellType.PROTECTION));
        hogwartsSpells.deleteSpellEvent(8);
        hogwartsSpells.printAllSpellEvents();
    }

}
