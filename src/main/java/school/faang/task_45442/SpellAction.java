package school.faang.task_45442;

import school.faang.task_45442.model.Spell;

@FunctionalInterface
public interface SpellAction {
    String doSpell(Spell spell);
}
