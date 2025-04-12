package school.faang.lambdas.corrector;

import school.faang.lambdas.Notification;

public class DefaultCorrector extends Corrector {

    public DefaultCorrector() {
        super(notification ->
                new Notification(notification.type(), "Notification manager %s".formatted(notification.message())));
    }
}