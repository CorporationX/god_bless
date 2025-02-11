package school.faang.task_57237;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SpellCaster {

    public void cast(String spellName, SpellAction<String> action) {
        if (spellName == null || spellName.isBlank()) {
            throw new IllegalArgumentException("spellName cannot be null or empty");
        }

        if (action == null) {
            throw new IllegalArgumentException("action cannot be null");
        }
        System.out.println(action.execute(spellName));
    }

    @FunctionalInterface
    public interface SpellAction<T> {
        String execute(T action);
    }
}
