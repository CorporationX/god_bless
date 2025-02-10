package task_BJS2_57276;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SpellCaster {

    public void cast(String spellName, SpellAction spellAction) {
        try {
            System.out.println(spellAction.spell(spellName));
        } catch (NullPointerException exception) {
            log.error("Попытка передать null в параметры метода cast: ", exception);
        }
    }
}
