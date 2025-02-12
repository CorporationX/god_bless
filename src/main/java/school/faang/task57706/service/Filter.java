package school.faang.task57706.service;

import java.util.function.Consumer;

@FunctionalInterface
public interface Filter {
    Consumer<Notification> checkFilter(String message);
}
