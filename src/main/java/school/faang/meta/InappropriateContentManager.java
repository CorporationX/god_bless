package school.faang.meta;

import java.util.HashSet;
import java.util.Set;

public class InappropriateContentManager {
    private Set<String> inappropriateContent = new HashSet<>(Set.of(
            "marijuana", "heroin", "cocaine", "fascism", "nazism", "win",
            "Taliban", "casino", "slots", "jackpot", "spins"
    ));

    public int contentFiltering(String message) {
        String[] messageForFilter = message.split(" ");
        int countOfKeywords = 0;
        for (String checkWord : messageForFilter) {
            if (inappropriateContent.contains(checkWord)) {
                countOfKeywords++;
            }
        }
        return countOfKeywords;
    }

    public String contentCorrection(String message) {
        for (String keyword : inappropriateContent) {
            String censoredWord = "*".repeat(keyword.length());
            message = message.replaceAll("(?i)" + keyword, censoredWord);
        }
        return message + " | This message contains inappropriate words, so we have hidden them";
    }
}
