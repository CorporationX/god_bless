package school.faang.lambdas.corrector;

import school.faang.lambdas.Notification;

public class TwitterCorrector extends Corrector {

    public TwitterCorrector() {
        super(notification -> new Notification(notification.type(), "Twitter %s".formatted(notification.message())));
    }
}