package Hogwarts;

public class Main {
    public static void main(String[] args) {
        SpellCaster spellCaster = new SpellCaster();
        String akcio = "Akcio";
        String bombarda = "Bombarda";
        String ascendio = "Ascendio";
        String lumos = "Lumos";

        spellCaster.cast(akcio, spellName -> "Притягивает к себе метлу " + spellName);
        spellCaster.cast(bombarda, spellName -> "Взрывает каменную перегородку " + spellName);
        spellCaster.cast(ascendio, spellName -> "Выталкивает себя из воды: " + spellName);
        spellCaster.cast(lumos, spellName -> "Зажигает на палочке свет : " + spellName);
    }
}
