package school.faang.ourlovelyhogwarts;

/*
 * Related to JIRA ticket: BJS2-71599
 * */
public class SpellCaster {
    public void caster(String spell, SpellAction spellAction) {
        System.out.println(spellAction.castSpell(spell));
    }
}
