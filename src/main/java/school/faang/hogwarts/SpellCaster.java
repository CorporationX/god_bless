package school.faang.hogwarts;

import lombok.NonNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SpellCaster {
    private static final Logger logger = LoggerFactory.getLogger(SpellCaster.class);

    public void cast(@NonNull String spell, @NonNull SpellAction action) {
        logger.info(action.perform(spell));
    }
}
