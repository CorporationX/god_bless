package school.faang.lambda.meta_universe;

import lombok.extern.slf4j.Slf4j;

import java.util.Objects;
import java.util.function.Predicate;

@Slf4j
public class MessageValidator implements Predicate<Notification> {

    @Override
    public boolean test(Notification notification) {
        String unacceptableSymbol = "*";
        if (Objects.equals(notification.getType(), null) || Objects.equals(notification.getMessage(), null)) {
            log.info("Your message type = {} and message = {}, null is not supported",
                    notification.getType(), notification.getMessage());
            return false;
        } else if (notification.getMessage().contains(unacceptableSymbol)) {
            log.info("You message contains unacceptable symbol {}", unacceptableSymbol);
            return false;
        } else {
            return true;
        }
    }
}
