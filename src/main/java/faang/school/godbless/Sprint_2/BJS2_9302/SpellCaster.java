package faang.school.godbless.Sprint_2.BJS2_9302;

public class SpellCaster {
        public void cast(String spellName, SpellAction spellAction){
            String result = spellAction.spell(spellName);
            System.out.println(result);
        }
}
