package ru.maks1979.task_45564;

public class Main {
    public static void main(String[] args) {
        SpellCaster spellCaster = new SpellCaster();
        String nameOfSpell = "Abracadabra";
        String anotherName = "SalamAleikum";
        String oneMoreName = "Avos'";

        spellCaster.cast(nameOfSpell, (spellname) -> "Calling the abracadabra" + spellname);
        spellCaster.cast(anotherName, (spellname) -> "Calling the muslim" + spellname);
        spellCaster.cast(oneMoreName, (spellname) -> "Calling the russian" + spellname);
    }
}
