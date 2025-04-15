package school.faang.lambda.meta_universe;

import lombok.extern.slf4j.Slf4j;

import java.util.Objects;
import java.util.function.Predicate;

@Slf4j
public class MessageValidator implements Predicate<Notification> {

    private static final String UNACCEPTABLE_SYMBOL = "*";

    @Override
    public boolean test(Notification notification) {
        if (Objects.isNull(notification.getType()) || Objects.isNull(notification.getMessage())) {
            log.info("Your message type = {} and message = {}, null is not supported",
                    notification.getType(), notification.getMessage());
            return false;
        } else if (notification.getMessage().contains(UNACCEPTABLE_SYMBOL)) {
            log.info("You message contains unacceptable symbol {}", UNACCEPTABLE_SYMBOL);
            return false;
        }
        return true;
    }
}
