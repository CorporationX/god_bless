package school.faang.task_45636;

public class Main {
    public static void main(String[] args) {
        SpellCaster spellCaster = new SpellCaster();

        String lumos = "Lumos";
        String expelliarmus = "Expelliarmus";
        String expectoPatronum = "Expecto Patronum";

        spellCaster.cast(lumos, (spell) -> spell + "! A bright light illuminates the darkness.");
        spellCaster.cast(expelliarmus, (spell) -> spell + "! Your opponent is disarmed!");
        spellCaster.cast(expectoPatronum, (spell) -> spell + "! A powerful Patronus appears to protect you.");
    }
}
