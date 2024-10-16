package school.faang.task2102;

public class Filter {

    private static final String[] FORBIDDEN_WORDS = {"shit", "niger"};

    public static Notification filterMessageContent(Notification notification) {
        String sanitizedMessage = obscureForbiddenWords(notification.getMessage());
        sanitizedMessage = obscureSensitiveInfo(sanitizedMessage);

        notification.setMessage(sanitizedMessage);
        return notification;
    }

    private static String obscureForbiddenWords(String message) {
        for (String word : FORBIDDEN_WORDS) {
            message = message.replaceAll("(?i)" + word, "***");
        }
        return message;
    }

    private static String obscureSensitiveInfo(String message) {
        return message.replaceAll("(?i)password: \\S+", "password: ***");
    }
}
