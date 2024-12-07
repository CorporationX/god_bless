package school.faang.task45450;

import school.faang.task45450.spell.SpellCaster;

public class Main {
    public static void main(String[] args) {

        SpellCaster spellCaster = new SpellCaster();

        String alohomora = "Alohomora";
        String lumos = "Lumos";
        String expelliarmus = "Expelliarmus";

        spellCaster.cast(alohomora, (spell) -> {
            System.out.println("Сказал заклинание: " + spell + "!");
            System.out.println("Взмахнул волшебной палочкой");
        });

        spellCaster.cast(lumos, (spell) -> {
            System.out.println("Сказал заклинание: " + spell + "!");
            System.out.println("Дважды взмахнул волшебной палочкой");
            System.out.println("Плюнул три раза через левое плечо");
        });

        spellCaster.cast(expelliarmus, (spell) -> {
            System.out.println("Сказал заклинание: " + spell + "!");
            System.out.println("Трижды взмахнул волшебной палочкой");
            System.out.println("Топнул левой ногой");
        });

    }
}
