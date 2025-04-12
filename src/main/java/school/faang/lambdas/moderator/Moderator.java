package school.faang.lambdas.moderator;

import lombok.extern.slf4j.Slf4j;
import school.faang.lambdas.Notification;
import school.faang.lambdas.exceptions.IllegalMessageException;

import java.util.List;

@Slf4j
public abstract class Moderator {

    protected List<Rule> rules;

    public boolean isDecentMessage(Notification notification) {
        for (Rule rule : rules) {
            if (rule.check().test(notification)) {
                throw new IllegalMessageException("Message blocked via %s, consider message requirements: \n %s"
                        .formatted(rule.name(), rule.description()));
            }
        }
        return true;
    }
}
