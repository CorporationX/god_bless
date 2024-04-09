package faang.school.godbless.lambdas.task_6.util;

import faang.school.godbless.lambdas.task_6.model.MessageFilter;

import java.util.List;

public class MessageProcessor {
    public boolean processMessage(String message, List<MessageFilter> filters) {
        for (MessageFilter filter : filters) {
            if (!filter.filter(message)) {
              return false;
            }
        }
        return true;
    }
}