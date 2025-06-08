package school.faang.events;

import java.util.UUID;

/**
 * @author Danil Pudovkin
 * @since 05.06.2025
 */
public record SpellEvent(Integer id, String eventType, String action) {

    public static final SpellEvent EMPTY = new SpellEvent(-1, "", "");
}
