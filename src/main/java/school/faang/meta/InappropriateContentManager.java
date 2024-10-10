package school.faang.meta;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InappropriateContentManager {
    private static final Set<String> INAPPROPRIATE_CONTENT = new HashSet<>(List.of(
            "marijuana", "heroin", "cocaine", "fascism", "nazism", "win",
            "Taliban", "casino", "slots", "jackpot", "spins"
    ));

    public static int contentFiltering(String message) {
        String[] messageForFilter = message.split(" ");
        int countOfKeywords = 0;
        for (String checkWord : messageForFilter) {
            if (INAPPROPRIATE_CONTENT.contains(checkWord)) {
                countOfKeywords++;
            }
        }
        return countOfKeywords;
    }

    public static String contentCorrection(String message) {
        for (String keyword : INAPPROPRIATE_CONTENT) {
            String censoredWord = "*".repeat(keyword.length());
            message = message.replaceAll("(?i)" + keyword, censoredWord);
        }
        return message + " | This message contains inappropriate words, so we have hidden them";
    }
}
