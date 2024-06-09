package BJS2_9158;

import ch.qos.logback.core.joran.spi.NoAutoStartUtil;

public class SpellCaster {
    public void cast(String spells, SpellAction spellAction){
        System.out.println(spellAction.cast(spells));
    }
}
