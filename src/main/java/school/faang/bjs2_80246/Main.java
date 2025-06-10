package school.faang.bjs2_80246;

public class Main {
    public static void main(String[] args) {
        SpellCaster spellCaster = new SpellCaster();

        String expelliarmus = "Expelliarmus";
        String lumos = "Lumos";
        String avadaKedavra = "AvadaKedavra";

        spellCaster.cast(avadaKedavra, spellName -> " You can kill an oponent using" + spellName);
        spellCaster.cast(lumos, spell -> " A beam of light is created by" + spell);
        spellCaster.cast(expelliarmus, spell -> " The opponent is disarmed by" + spell);
    }
}
