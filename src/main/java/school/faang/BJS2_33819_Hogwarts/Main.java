package school.faang.BJS2_33819_Hogwarts;

public class Main {
    public static void main(String[] args) {
        SpellCaster spellCaster = new SpellCaster();

        String incendio = "Incendio";
        String wingardiumLeviosa = "Wingardium Leviosa";
        String expectoPatronum = "Expecto Patronum";

        spellCaster.cast(incendio, (spell) -> "A fire is conjured by " + spell);
        spellCaster.cast(wingardiumLeviosa, (spell) -> "The object is levitated by " + spell);
        spellCaster.cast(expectoPatronum, (spell) -> "A Patronus is summoned to ward off dementors by " + spell);
    }
}
