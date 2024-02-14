package faang.school.godbless.googletranslator;

import java.util.function.BiConsumer;

public class DictionaryProcessor {
    void processWord(String word, String translation, BiConsumer<String, String> consumer){
        consumer.accept(word, translation);
    }
}
