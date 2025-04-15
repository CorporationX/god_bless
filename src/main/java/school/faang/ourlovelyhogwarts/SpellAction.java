package school.faang.ourlovelyhogwarts;

/*
 * Related to JIRA ticket: BJS2-71599
 * */
@FunctionalInterface
public interface SpellAction {
    String castSpell(String spellName);
}
