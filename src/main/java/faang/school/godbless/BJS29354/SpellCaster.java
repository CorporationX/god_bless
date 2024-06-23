package faang.school.godbless.BJS29354;

public record SpellCaster(String spellName) {

    public void cast(String spellName, SpellAction spellAction) {
        System.out.println(spellAction.cast(spellName, spellAction));
    }
}