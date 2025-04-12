package school.faang.lambdas.moderator;

import lombok.extern.slf4j.Slf4j;
import school.faang.lambdas.Notification;
import school.faang.lambdas.exceptions.IllegalMessageException;

import java.util.Arrays;
import java.util.List;

@Slf4j
public abstract class Moderator {

    protected List<Rule> rules;

    public Moderator(Rule... rules) {
        this.rules = Arrays.asList(rules);
    }

    public boolean isDecentMessage(Notification notification) {
        for (Rule rule : this.rules) {
            if (rule.check().test(notification)) {
                throw new IllegalMessageException("Message blocked via %s, consider message requirements: \n %s"
                        .formatted(rule.name(), rule.description()));
            }
        }
        return true;
    }
}
