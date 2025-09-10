package school.faang.bjs2_87396_Hogvarts;

public class Main {
    public static void main(String[] args) {
        String wingardiumLeviosa = "Wingardium Leviosa";
        String incendio = "Incendio";
        String expectoPatronum = "Expecto Patronum";

        SpellCaster spellCaster = new SpellCaster();
        spellCaster.cast(wingardiumLeviosa, (spell) ->
                "The feather begins to float in the air thanks to " + spell);
        spellCaster.cast(incendio, (spell) ->
                "A jet of flames erupts from the wand with " + spell);
        spellCaster.cast(expectoPatronum, (spell) ->
               "A silvery stag bursts from the wand, conjured by " + spell);
    }
}