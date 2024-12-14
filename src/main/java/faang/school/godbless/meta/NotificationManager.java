package faang.school.godbless.meta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class NotificationManager {
    private final Map<String, List<Handler>> handlers = new HashMap<>();
    private final Map<String, List<Filter>> filters = new HashMap<>();

    public String registerHandler(String type, Consumer<Notification> handler) {
        if (type == null || type.isEmpty() || handler == null) {
            return null;
        }

        if (!handlers.containsKey(type)) {
            handlers.put(type, new ArrayList<>());
        }

        Handler h = new Handler(handler);
        handlers.get(type).add(h);

        return h.getId();
    }

    public void unregisterHandlerById(String id) {
        if (id == null) {
            return;
        }

        handlers.forEach((key, value1) -> value1.removeIf(value -> value.getId().equals(id)));
    }

    public String registerFilter(String type, Predicate<Notification> filter, Consumer<Notification> handler, Function<Notification, String> transformer) {
        if (type == null || type.isEmpty() || filter == null || handler == null) {
            return null;
        }

        if (!filters.containsKey(type)) {
            filters.put(type, new ArrayList<>());
        }

        Filter f = new Filter(filter, handler, transformer);
        filters.get(type).add(f);

        return f.getId();
    }

    public void unregisterFilterById(String id) {
        if (id == null) {
            return;
        }

        filters.forEach((key, value1) -> value1.removeIf(value -> value.getId().equals(id)));
    }

    public void sendNotification(Notification notification) {
        if (notification == null) {
            return;
        }

        String type = notification.getType();

        List<Filter> filtersList = filters.get(type);
        if (filtersList != null) {
            filtersList.forEach(filter -> {
                if (filter.getPredicate().test(notification)) {
                    filter.getConsumer().accept(notification);
                    String newMessage = filter.getMessageTransformer().apply(notification);
                    notification.setMessage(newMessage);
                }
            });
        }

        List<Handler> handlersList = handlers.get(type);
        if (handlersList != null) {
            handlersList.forEach(handler -> handler.getConsumer().accept(notification));
        }
    }
}
