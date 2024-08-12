package faang.school.godbless.BJS2_21979;

import lombok.AllArgsConstructor;

import java.util.Set;
import java.util.function.Function;

@AllArgsConstructor
public class CensorshipManager {

    private Function<String, String> censorshipManager;
    private Set<String> badWords;

    public String censorBadWords(String[] words) {
        for (int i = 0; i < words.length; i++) {
            if (badWords.contains(words[i].toLowerCase())) {
                words[i] = censorshipManager.apply(words[i]);
            }
        }
        return String.join(" ", words);
    }
}
