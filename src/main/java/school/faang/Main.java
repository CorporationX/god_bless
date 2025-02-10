package school.faang;


public class Main {
    public static void main(String[] args) {
        SpellCaster spellCaster = new SpellCaster();

        String piu = "Piu";
        String bum = "Bum";
        String viu = "Viu";

        spellCaster.cast(piu, (spellName) -> "piu piu piu " + spellName);
        spellCaster.cast(bum, (spellName) -> "the shield activated " + spellName);
        spellCaster.cast(viu, (spellName) -> "spell go back by " + spellName);

    }
}
