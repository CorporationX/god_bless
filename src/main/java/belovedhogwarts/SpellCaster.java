package belovedhogwarts;

public class SpellCaster {
    public void cast(String spell, SpellAction spellAction) {
        System.out.println(spellAction.spellCast(spell));
    }
}
