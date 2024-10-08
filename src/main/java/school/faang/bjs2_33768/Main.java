package school.faang.bjs2_33768;

public class Main {

    public static void main(String[] args) {
        SpellCaster spellCaster = new SpellCaster();

        String chaosBolt = "Chaos bolt";
        String holyLight = "Holy Light";
        String deathCoil = "Death coil";

        spellCaster.cast(chaosBolt, (spellName -> "Damage done by " + spellName));
        spellCaster.cast(holyLight, (spellName -> "Healed by " + spellName));
        spellCaster.cast(deathCoil, (spellName -> "Feared by " + spellName));
    }
}
