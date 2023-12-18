package faang.school.godbless.alexbulgakoff.functionalinterfaceslambdas.spamfilters;

import java.util.List;

/**
 * @author Alexander Bulgakov
 */

public class MessageProcessor {

    public boolean processMessage(String message, List<MessageFilter> filters) {
        return filters.stream().allMatch(f -> f.filter(message));
    }
}
