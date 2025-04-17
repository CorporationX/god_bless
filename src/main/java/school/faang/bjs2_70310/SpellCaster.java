package school.faang.bjs2_70310;

public class SpellCaster
{
    public void cast (String spellName,SpellAction action)
    {
        String result = action.cast(spellName);
        System.out.println(result);
    }
}
