package faang.school.godbless.sprint3.GoogleTranslate.classes;

import java.util.function.BiConsumer;

public class DictionaryProcessor {

    public static final String WORD_IS_EMPTY_OR_NULL = "Word is empty or null";
    public static final String TRANSLATE_IS_EMPTY_OR_NULL = "Translate word is empty or null";

    public void processWord(String word, String translate, BiConsumer<String, String> consumer) {
        if (word == null || word.isEmpty()) {
            throw new IllegalArgumentException(WORD_IS_EMPTY_OR_NULL);
        }
        if (translate == null || translate.isEmpty()) {
            throw new IllegalArgumentException(TRANSLATE_IS_EMPTY_OR_NULL);
        }
        consumer.accept(word, translate);
    }
}
