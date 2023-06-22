package faang.school.godbless.sprint3.google_translator;

import java.util.function.BiConsumer;

public class DictionaryProcessor {
    public void processWord(String word, String translation, BiConsumer<String, String> action) {
        action.accept(word, translation);
    }
}
