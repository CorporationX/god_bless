package school.faang.lovelyhogwarts;

public class Main {
    public static void main(String[] args) {
        SpellCaster spellCaster = new SpellCaster();
        String fireball = "fireball";
        String icestrike = "icestrike";
        String lighting = "lightning";

        spellCaster.cast(fireball, (action) -> "Door burned by " + fireball);
        spellCaster.cast(icestrike, (action) -> "Ghoul freezed by " + icestrike);
        spellCaster.cast(fireball, (action) -> "Undead defeated by " + lighting);
    }
}
