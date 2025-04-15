package school.faang.metaverse;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/*
 * Related to JIRA ticket: BJS2-71883
 * */
@RequiredArgsConstructor
@Getter
public class Notification {
    private final NotificationType type;
    private final String message;
}
