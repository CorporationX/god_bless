package school.faang;

public class SpellCaster {

    public static final String FIREBALL = "fireBall";
    public static final String LIGHTNING_BELT = "lightningBelt";
    public static final String ICE_SHARD = "iceShard";

    public void cast(String spellName, SpellAction make) {
        if (spellName == null || make == null) {
            throw new IllegalArgumentException("spellName and make cannot be null");
        }
        String result = make.castSpell(spellName);
        System.out.println("You make a spell: " + result);
    }

    public static void main(String[] args) {
        SpellCaster spell = new SpellCaster();

        spell.cast(FIREBALL, (castSpell) ->
                "Enemies burned alive after use " + castSpell + "!");
        spell.cast(ICE_SHARD, (castSpell) ->
                "Enemies are turned into ice " + castSpell + "!");
        spell.cast(LIGHTNING_BELT, (castSpell) ->
                "Enemies are struck by chain lightning" + " after use " + castSpell + "!");
    }
}