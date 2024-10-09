package school.faang;

import school.faang.spell.services.SpellCaster;

public class Main {
    public static void main(String[] args) {
        SpellCaster spellCaster = new SpellCaster();

        String alohomora = "Alohomora";
        String lumos = "Lumos";
        String expelliarmus = "Expelliarmus";

        String fly = "Fly";
        String grow = "Grow";

        System.out.println("Пример из самой задачи: ");

        spellCaster.cast(alohomora, (spell) -> "The door is unlocked by " + spell);
        spellCaster.cast(lumos, (spell) -> "A beam of light is created by " + spell);
        spellCaster.cast(expelliarmus, (spell) -> "The opponent is disarmed by " + spell);

        System.out.println("===============================");

        spellCaster.cast(fly, (spell) -> "The apple is flyed by " + spell);
        spellCaster.cast(grow,(spell) -> "The tree is grown by " + spell);

    }
}
