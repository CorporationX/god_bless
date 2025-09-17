package school.faang.hogwarts;

public class Main {
    public static void main(String[] args) {
        SpellCaster spellCaster = new SpellCaster();
        String sektusempra = "Sektusempra";
        String vingardiomLeviosa = "vingardiomLeviosa";
        String actio = "actio";

        spellCaster.cast(sektusempra, (spell) -> "The opponent is damaged by " + spell);
        spellCaster.cast(vingardiomLeviosa, (spell) -> "The object in air by " + spell);
        spellCaster.cast(actio, (spell) -> "The object is bringing by " + spell);
    }
}
