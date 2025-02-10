package school.faang;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class SpellCaster {

    public void cast(String spellName, SpellAction spellAction) {
        String result = spellAction.action(spellName);
        System.out.println(result);

    }

}
