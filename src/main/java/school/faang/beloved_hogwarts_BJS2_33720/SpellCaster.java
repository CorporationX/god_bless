package school.faang.beloved_hogwarts_BJS2_33720;

public class SpellCaster {
    public void caster(String spell, SpellAction spellAction) {
        System.out.println(spellAction.performSpell(spell));
    }

    public static void main(String[] args) {
        String accio = "Accio";
        String incendio = "Incendio";
        String protego = "Protego";

        SpellCaster spellCaster = new SpellCaster();
        spellCaster.caster(accio, spell -> "An object is summoned by " + spell);
        spellCaster.caster(incendio, spell -> "A blazing fire is conjured by " + spell);
        spellCaster.caster(protego, spell -> "A magical barrier is raised by " + spell);

    }


}
