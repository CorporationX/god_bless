package meta_universe;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class NotificationManager {
    Map<TypNotification, Function<Notification, String>> notificationKeeper = new HashMap<>();
    private static final List<String> FORBIDDEN_WORDS = List.of("Лох", "Вонючка", "Тупица");

    public void registerHandler(TypNotification type, Function<Notification, String> function) {
        notificationKeeper.put(type, function);
    }

    public void sendNotification(Notification notification, Map<TypNotification, Function<Notification, String>> notificationKeeper) {
        notification.setMessage(filterMessage(notification));
        notificationKeeper.get(notification.getType()).apply(notification);
    }

    private String filterMessage(Notification notification) {
        String joinForbiddenWords = FORBIDDEN_WORDS.stream()
                .map(Pattern::quote)
                .collect(Collectors.joining("|"));

        Pattern pattern = Pattern.compile(joinForbiddenWords, Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);
        return pattern.matcher(notification.getMessage()).replaceAll(matchResult ->
                "*".repeat(matchResult.group().length()));
    }

}
