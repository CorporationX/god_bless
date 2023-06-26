package faang.school.godbless.sprint2.google_translator;

import java.util.function.BiConsumer;

public class DictionaryProcessor {
    public void processWord(String word, String translation, BiConsumer<String, String> biConsumer) {
        biConsumer.accept(word,translation);
    }
}
