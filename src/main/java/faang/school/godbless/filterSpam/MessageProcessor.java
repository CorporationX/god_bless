package faang.school.godbless.filterSpam;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MessageProcessor {
    public SpamCheckStatus processMessage(String message, List<MessageFilter> messageFilters) {
        Map<SpamCheckStatus, Integer> counter = getCounterSpamCheckStatus();
        updateCounterBasedOnFilters(message, messageFilters, counter);
        return determineFinalStatus(counter);
    }

    private void updateCounterBasedOnFilters(String message, List<MessageFilter> messageFilters, Map<SpamCheckStatus, Integer> counter) {
        for (MessageFilter messageFilter : messageFilters) {
            if (messageFilter.filter(message)) {
                incrementCounter(counter, SpamCheckStatus.NOT_PASSED);
            } else {
                incrementCounter(counter, SpamCheckStatus.PASSED);
            }
        }
    }

    private void incrementCounter(Map<SpamCheckStatus, Integer> counter, SpamCheckStatus status) {
        counter.put(status, counter.get(status) + 1);
    }

    private SpamCheckStatus determineFinalStatus(Map<SpamCheckStatus, Integer> counter) {
        if (counter.get(SpamCheckStatus.NOT_PASSED) > 0) {
            return SpamCheckStatus.NOT_PASSED;
        } else {
            return SpamCheckStatus.PASSED;
        }
    }

    private static Map<SpamCheckStatus, Integer> getCounterSpamCheckStatus() {
        Map<SpamCheckStatus, Integer> counter = new HashMap<>();
        counter.put(SpamCheckStatus.NOT_PASSED, 0);
        counter.put(SpamCheckStatus.PASSED, 0);
        return counter;
    }
}
