package school.faang.spellmanagement;

public class App {
    public static void main(String[] args) {
        SpellCaster spellCaster = new SpellCaster();

        spellCaster.cast(Spell.LUMOS, spell -> spell.getName() + ": " + spell.getDescription());
        spellCaster.cast(Spell.EXPELLIARMUS, spell -> spell.getName() + ": " + spell.getDescription());
        spellCaster.cast(Spell.WINGARDIUM_LEVIOSA, spell -> spell.getName() + ": " + spell.getDescription());
        spellCaster.cast(Spell.EXPECTRO_PATRONUM, spell -> spell.getName() + ": " + spell.getDescription());
    }
}
