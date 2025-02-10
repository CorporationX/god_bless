package school.faang.task_57237;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SpellCaster {

    public void cast(String spellName, SpellAction<String> action) {

        if (spellName == null || spellName.isBlank()) {
            log.info("название заклинания либо NULL либо пустое!");
            return;
        }

        if (action == null) {
            log.info("Поле заклинания не должно быть пустым");
            return;
        }
        System.out.println(action.execute(spellName));
    }

    public interface SpellAction<T> {
        String execute(T action);
    }
}
