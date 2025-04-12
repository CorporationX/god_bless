package school.faang.hogwarts;

public class Main {
    public static void main(String[] args) {
        SpellCaster spellCaster = new SpellCaster();

        String stupefy = "Stupefy";
        String wingardiumLeviosa = "Wingardium Leviosa";
        String protego = "Protego";

        spellCaster.cast(stupefy, spell -> "Renders the target unconscious or temporarily paralyzed by " + spell);
        spellCaster.cast(wingardiumLeviosa, spell -> "Makes objects fly or float by " + spell);
        spellCaster.cast(protego, spell -> "Creates a magical barrier to deflect spells by " + spell);
    }
}
