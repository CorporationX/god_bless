package school.faang.eventhandler;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/*
 * Related to JIRA ticket: BJS2-68668
 */
@AllArgsConstructor
@Getter
@ToString
public class SpellEvent {
    private static int idCounter = 0;

    private final int id = ++idCounter;
    private final String eventType;
    private String action;
}
