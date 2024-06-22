package faang.school.godbless.BJS29354;

@FunctionalInterface
public interface SpellAction {
    String cast(String spellName, SpellAction spell);
}