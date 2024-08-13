package faang.school.godbless;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SpellCaster {
    public void cast(String spell, SpellAction action) {
        String result = action.perfom(spell);
        System.out.println("The spell " + spell + " is being cast. " +  "Result: " + result);
    }
}