package school.faang.streams.stream2.hogwartshogwartsourbelovedhogwarts;

public class SpellCaster {

    void cast(String spellName, SpellAction spellAction) {
        String spellResult = spellAction.act(spellName);

        System.out.println(spellResult);
    }
}
