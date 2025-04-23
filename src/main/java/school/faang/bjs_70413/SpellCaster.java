package school.faang.bjs_70413;

public class SpellCaster {
    public void cast(String spellName, SpellAction action) {
        String result = action.perform(spellName);
        System.out.println("Заклинание " + spellName + "выполнено: " + result);
    }
}
