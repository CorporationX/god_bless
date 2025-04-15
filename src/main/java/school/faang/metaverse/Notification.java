package school.faang.metaverse;

import lombok.AllArgsConstructor;
import lombok.Getter;

/*
 * Related to JIRA ticket: BJS2-71883
 * */
@AllArgsConstructor
@Getter
public class Notification {
    private final NotificationType type;
    private final String message;
}
