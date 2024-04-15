package faang.school.godbless.sprint_2.meta_universe;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class BadWordsManager {

    private Map<String, Function<String, String>> handlers;

    public BadWordsManager() {
        this.handlers = new HashMap<>();
    }

    void registerHandler(String badWord, Function<String, String> handler) {
        handlers.put(badWord.toLowerCase(), handler);
    }

    // Не лучшее решение, не учтены знаки препинания.
    // С ними чуть запарно, поэтому решил сделать простую валидацию просто чтобы поработать с лямбдами.
    String validateMessage(String message) {
        String[] words = message.split(" ");

        for (int i = 0; i < words.length; i++) {
            if (handlers.containsKey(words[i].toLowerCase())) {
                words[i] = handlers.get(words[i].toLowerCase()).apply(words[i]);
            }
        }

        return String.join(" ", words);
    }
}