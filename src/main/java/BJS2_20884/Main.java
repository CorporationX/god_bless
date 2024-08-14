package BJS2_20884;

public class Main {
    public static void main(String[] args) {
        String alohamora = "'Alohamora!'";
        String lumos = "'Lumos!'";
        String expelliarmus = "'Expelliarmus!'";

        System.out.println(SpellCaster.cast(alohamora, spell -> spell + " The door is slowly opens..." ));
        System.out.println(SpellCaster.cast(lumos, spell -> spell + " Bright light blinded everyone around..."));
        System.out.println(SpellCaster.cast(expelliarmus, spell -> spell + " The wand in hand of Ronald Weasley has fallen down..."));
    }
}
