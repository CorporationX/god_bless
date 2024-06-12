package faang.school.godbless.lambda;

import java.util.function.BiConsumer;

public class DictionaryProcessor {

    public void processWord(String word, String translation, BiConsumer<String, String> addTranslator) {
        addTranslator.accept(word, translation);
    }
}
