package school.faang;

public class SpellCaster {
    public void cast(String spellName, SpellAction action) {
        String result = action.castSpell(spellName);
        System.out.println("You make a spell: " + result);
    }

    public static void main(String[] args) {
        SpellCaster spell = new SpellCaster();
        String fireBall = "fireBall";
        String lightningBelt = "lightningBelt";
        String iceShard = "iceShard";

        spell.cast(fireBall, (castSpell) -> "Enemies burned alive after use " + castSpell + "!");
        spell.cast(iceShard, (castSpell) -> "Enemies are turned into ice " + castSpell + "!");
        spell.cast(lightningBelt, (castSpell) -> "Enemies are struck by chain lightning" +
                " after use " + castSpell + "!");
    }
}