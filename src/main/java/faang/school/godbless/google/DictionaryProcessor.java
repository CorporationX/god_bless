package faang.school.godbless.google;

import java.util.function.BiConsumer;

public class DictionaryProcessor {

    public void processWord(String word, String translation, BiConsumer<String, String> processing) {
        processing.accept(word, translation);
    }
}
