package school.faang.translator;

import java.util.function.BiConsumer;

/**
 * @author Danil Pudovkin
 * @since 11.06.2025
 */
public class DictionaryProcessor {

    public void processWord(String originalWord, String translatedWord, BiConsumer<String, String> consumer) {
        consumer.accept(originalWord, translatedWord);
    }
}
