package faang.school.godbless.hogvarts;

import org.junit.jupiter.api.BeforeEach;

public class SpellCaster {
  public void cast(String spellName, SpellAction spellAction) {
    String spellResult = spellAction.spell(spellName);
    System.out.println(spellResult);
  }
}
