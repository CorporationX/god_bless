package school.faang.task_45447;

public class Main {
    public static void main(String[] args) {
        SpellCaster spellCaster = new SpellCaster();

        SpellAction spellActionOne = (String spell) -> Spell.SPELL.get(spell) + "  IS FULFILLED BY " + spell;

        for (int i = 0; i < 5; i++) {
            System.out.println(spellCaster.cast(Spell.getRandomSpell().get("eventType"), spellActionOne));
        }
    }
}


