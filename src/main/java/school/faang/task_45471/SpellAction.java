package school.faang.task_45471;

@FunctionalInterface
public interface SpellAction<C> {
    String castSpell(C spellName);
}
