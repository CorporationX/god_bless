package school.faang.lambda.meta_universe;

import java.util.function.Predicate;

public class MessageValidator implements Predicate<Object> {

    public boolean test(Notification notification, String unacceptableSymbol) {
        return notification.getMessage().contains(unacceptableSymbol);
    }

    @Override
    public boolean test(Object o) {
        return false;
    }
}
