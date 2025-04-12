package school.faang.lambdas.corrector;

import school.faang.lambdas.Notification;

import java.util.function.Function;

public abstract class Corrector {

    private final Function<Notification, Notification> correctRule;

    protected Corrector(Function<Notification, Notification> correctRule) {
        this.correctRule = correctRule;
    }

    public Notification correct(Notification notification) {
        return correctRule.apply(notification);
    }
}
