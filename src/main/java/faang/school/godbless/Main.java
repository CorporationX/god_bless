package faang.school.godbless;

interface SpellAction {
    String convertToAction(String spell);
}

class SpellCaster {

    void cast(String spell, SpellAction spellAction) {
        System.out.println(spellAction.convertToAction(spell));
    }

    public static void main(String[] args) {

        SpellCaster spellCaster = new SpellCaster();

        String alohomora = "Alohomora";
        String lumos = "Lumos";
        String expelliarmus = "Expelliarmus";

        spellCaster.cast(alohomora, (s) -> "The door is unlocked by " + s);
        spellCaster.cast(lumos, (s) -> "A beam of light is created by " + s);
        spellCaster.cast(expelliarmus, (s) -> "The opponent is disarmed by " + s);
    }
}