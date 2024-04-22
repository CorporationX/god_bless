package faang.school.godbless.lambda.BJS2_5696;

public class Main {
    public static void main(String[] args) {
        SpellCaster spellCaster = new SpellCaster();

        String accio = "Accio";
        String stupefy = "Stupefy";
        String wingardiumLeviosa = "Wingardium Leviosa";

        spellCaster.cast(accio, (spell) -> "An object is summoned by " + spell);
        spellCaster.cast(stupefy, (spell) -> "The opponent is stunned by " + spell);
        spellCaster.cast(wingardiumLeviosa, (spell) -> "An object is levitated by " + spell);
    }
}
