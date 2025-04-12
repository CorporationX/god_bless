package school.faang.lambdas.corrector;

import school.faang.lambdas.Notification;

public class AmazonCorrector extends Corrector {

    public AmazonCorrector() {
        super(notification -> new Notification(notification.type(), "Amazon %s".formatted(notification.message())));
    }
}