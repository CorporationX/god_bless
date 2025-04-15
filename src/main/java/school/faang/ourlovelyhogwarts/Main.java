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

        spellCaster.caster(alohomora, (spell) -> String.format("The door is unlocked by %s", spell));
        spellCaster.caster(lumos, (spell) -> String.format("A beam of light is created by %s", spell));
        spellCaster.caster(expelliarmus, (spell) -> String.format("The opponent is disarmed by %s", spell));
    }
}
