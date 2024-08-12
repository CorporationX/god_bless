package com.functional.filter;

import java.util.List;

public class MessageProcessor {

    public boolean processMessage(String message, List<MessageFilter> filterList) {
        for (MessageFilter filter : filterList) {
            if (!filter.filter(message)) {
                return false;
            }
        }
        return true;
    }
}
