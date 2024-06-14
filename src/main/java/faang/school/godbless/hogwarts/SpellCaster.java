package faang.school.godbless.hogwarts;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Evgenii Malkov
 */
@Slf4j
public class SpellCaster {

  void cast(String name, SpellAction<String> spellAction) {
    log.info(String.format("%s", spellAction.doSpell(name)));
  }
}
