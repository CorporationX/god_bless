package school.faang.task57258.service;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
public class SpellCaster {
    private final String alahomora = "Alahomora";
    private final String lumos = "Lumos";
    private final String expelliarmus = "Expelliarmus";
    public void cast(String spellName, SpellAction action) {
        if (spellName==null || action == null) {
            throw new IllegalArgumentException("The data should not be empty");
        }
        String result = action.castSpell(spellName);
        System.out.println("Spell result: " + result);
    }
}
