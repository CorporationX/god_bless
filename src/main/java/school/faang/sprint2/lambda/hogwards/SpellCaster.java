package school.faang.sprint2.lambda.hogwards;

import lombok.NonNull;

public class SpellCaster {
    public void cast(@NonNull String spellName, @NonNull SpellAction spellAction) {
        System.out.println("\n....................");
        System.out.println("Method 'cast()' starts...");
        String result = spellAction.act(spellName);
        System.out.println(result);
        System.out.println("Method 'cast()' ends.");
        System.out.println(".....................\n");
    }
}
