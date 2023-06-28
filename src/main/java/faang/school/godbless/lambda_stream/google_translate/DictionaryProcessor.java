package faang.school.godbless.lambda_stream.google_translate;

import java.util.function.BiConsumer;

public class DictionaryProcessor {
    public static void processWord(String word, String translation, BiConsumer<String, String> translationConsumer) {
        translationConsumer.accept(word, translation);
    }
}