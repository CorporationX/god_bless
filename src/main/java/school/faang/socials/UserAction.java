package school.faang.socials;

import java.time.LocalDate;

/**
 * @author Danil Pudovkin
 * @since 13.06.2025
 */
public record UserAction(int id, String name, ActionType actionType, LocalDate actionDate, String content) {
}
