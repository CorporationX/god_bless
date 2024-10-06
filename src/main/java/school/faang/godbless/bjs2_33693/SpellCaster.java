package school.faang.godbless.bjs2_33693;

import java.util.function.Consumer;

public class SpellCaster {

  public void cast(String spellName, SpellAction spellAction) {
    System.out.println(spellAction.executeSpell(spellName));
  }
}
