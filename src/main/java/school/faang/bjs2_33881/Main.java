package school.faang.bjs2_33881;

public class Main {
    public static void main(String[] args) {
        SpellCaster spellCaster = new SpellCaster();

        String spellAccio = "Accio";
        String spellStupefy = "Stupefy";
        String spellWingardiumLeviosa = "Wingardium Leviosa";
        String spellPetrificusTotalus = "Petrificus Totalus";

        spellCaster.cast(spellAccio, spellName -> "An object is summoned by " + spellName);
        spellCaster.cast(spellStupefy, spellName -> "The opponent is stunned by " + spellName);
        spellCaster.cast(spellWingardiumLeviosa, spellName -> "An object is levitated by " + spellName);
        spellCaster.cast(spellPetrificusTotalus, spellName -> "The opponent is paralyzed by " + spellName);
    }

}
