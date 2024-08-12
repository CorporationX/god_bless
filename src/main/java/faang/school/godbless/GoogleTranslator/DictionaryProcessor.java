package faang.school.godbless.GoogleTranslator;

import java.util.function.BiConsumer;

public class DictionaryProcessor {
    public static void processWord(String original, String translate, BiConsumer<String, String> consumer) {
        consumer.accept(original, translate);
    }
}
