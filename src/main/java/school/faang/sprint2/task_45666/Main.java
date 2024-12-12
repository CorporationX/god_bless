package school.faang.sprint2.task_45666;

public class Main {
    public static void main(String[] args) {
        SpellCaster spellCaster = new SpellCaster();

        String alohomora = "Alohomora";
        String lumos = "Lumos";
        String expelliarmus = "Expelliarmus";
        String accio = "Accio";
        String protego = "Protego";
        String expectoPatronum = "ExpectoPatronum";
        String wingardiumLeviosa = "WingardiumLeviosa";
        String stupefy = "Stupefy";

        SpellAction spellAction1 = new SpellAction() {
            @Override
            public String castSpell(String spellName) {
                return "A beam of light is created by " + spellName;
            }
        };

        SpellAction spellAction2 = spell -> "The door is unlocked by " + spell;

        spellCaster.cast(alohomora, (spell) -> "The door is unlocked by " + spell);
        spellCaster.cast(lumos, (spell) -> "A beam of light is created by " + spell);
        spellCaster.cast(expelliarmus, (spell) -> "The opponent is disarmed by " + spell);
        spellCaster.cast(lumos, spellAction1);
        spellCaster.cast(alohomora, spellAction2);
        spellCaster.cast(accio, (spell) -> "The object is summoned by " + spell);
        spellCaster.cast(protego, (spell) -> "A protective shield is conjured by " + spell);
        spellCaster.cast(expectoPatronum, (spell) -> "A Patronus is summoned by " + spell);
        spellCaster.cast(wingardiumLeviosa, (spell) -> "An object is levitated by " + spell);
        spellCaster.cast(stupefy, (spell) -> "The target is stunned by " + spell);
    }
}
