package faang.school.godbless.BJS2_5104;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class SpellCaster {
  public void cast(String spell, SpellAction spellAction) {
    System.out.println(spellAction.action(spell));
  }
}
