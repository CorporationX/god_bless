package school.faang.hogwarts;

public class Main {
    public static void main(String[] args) {
        SpellCaster spellCaster = new SpellCaster();

        spellCaster.cast("Fireball", spellName -> spellName + " bursts everything with flame!");
        spellCaster.cast("Frost Arrow", spellName -> spellName + " freezes the enemy solid!");
        spellCaster.cast("Magic Shield", spellName -> spellName + " protects you with a glowing barrier!");
    }
}
