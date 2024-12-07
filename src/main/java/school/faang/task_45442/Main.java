package school.faang.task_45442;

import school.faang.task_45442.model.Spell;

public class Main {
    public static void main(String[] args) {
        SpellCaster spellCaster = new SpellCaster();
        spellCaster.cast(
                Spell.WINGARDIUM_LEVIOSA,
                (spell) -> "I cast a " + spell.name() + " and I started levitating!"
        );
    }
}
