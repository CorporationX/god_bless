package faang.school.godbless.google_translator_is_under_our_control;

import java.util.function.BiConsumer;

public class DictionaryProcessor {
    public void processWord(String word, String translate, BiConsumer<String, String> function) {
        function.accept(translate, word);
    }
}
