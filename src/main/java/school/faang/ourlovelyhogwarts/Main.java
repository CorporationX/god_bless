package school.faang.ourlovelyhogwarts;

/*
* Related to JIRA ticket: BJS2-71599
 * */
public class Main {
    public static void main(String[] args) {
        SpellCaster spellCaster = new SpellCaster();

        String alohomora = "Alohomora";
        String lumos = "Lumos";
        String expelliarmus = "Expelliarmus";

        spellCaster.caster(alohomora, (spell) -> "The door is unlocked by " + spell);
        spellCaster.caster(lumos, (spell) -> "A beam of light is created by " + spell);
        spellCaster.caster(expelliarmus, (spell) -> "The opponent is disarmed by " + spell);
    }
}
