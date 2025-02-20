package school.faang.BJS2_57779;

public class Filters {
    private static final int MIN_LENGTH_MESSAGE = 10;
    private static final String FORBIDDEN_WORD = "спам";
    private static final String FORBIDDEN_EMOJI = "😀";

    public static MessageFilter spamFilter() {
        return message -> !message.toLowerCase().contains(FORBIDDEN_WORD);
    }

    public static MessageFilter lengthFilter() {
        return message -> message.length() > MIN_LENGTH_MESSAGE;
    }

    public static MessageFilter emojiFilter() {
        return message -> !message.contains(FORBIDDEN_EMOJI);
    }
}
