package faang.school.godbless.our_hogwards;

public record SpellCaster() {
    public void cast(String spellName, SpellAction spellAction) {
        System.out.println(spellAction.cast(spellName));

    }
}
