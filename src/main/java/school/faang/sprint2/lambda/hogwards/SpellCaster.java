package school.faang.sprint2.lambda.hogwards;

public class SpellCaster {
    public void cast(String spellName, SpellAction spellAction) {
        System.out.println("Method 'cast()' starts...");
        String result = spellAction.act(spellName);
        System.out.println(result);
        System.out.println("Method 'cast()' ends.");
    }
}
